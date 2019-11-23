package com.company;

import java.io.*;
import java.util.*;

/**
 * Klasse die Benutzer in einer Datenhaltung speichert
 * und diese verwaltet
 */
public class BenutzerVerwaltungAdmin implements BenutzerVerwaltung, Serializable {

    /**
     * Datenhaltung in der die Nutzer gespeichert werden
     */
    private Vector<Benutzer> ben_List;

    /**
     * Default Konstruktor
     * Initialisiert den Vektor
     */
    BenutzerVerwaltungAdmin(){
        ben_List = new Vector<Benutzer>();
    }

    /**
     * Initialisiert die persistente Datenstruktur
     */
    void dbInitialisieren(){
        try{
            FileOutputStream fs = new FileOutputStream("daten.s");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(ben_List);
            os.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Fügt der Datenhaltung ein Objekt vom Typ Benutzer hinzu
     * @param benutzer                          :Der Benutzer, der Eingefügt werden soll
     * @throws IllegalArgumentException      :Objekt ist nicht vom Typ Benutzer
     * @throws NullPointerException          :Das Objekt ist NULL
     */
    public void benutzerEintragen (Benutzer benutzer) throws IllegalArgumentException{
        if(benutzer.passWort.length == 0){
            throw  new IllegalArgumentException();
        }
        try{
            FileInputStream fis = new FileInputStream("daten.s");
            ObjectInputStream is = new ObjectInputStream(fis);
            ben_List = (Vector<Benutzer>) is.readObject();
            is.close();
            ben_List.add(benutzer);
            FileOutputStream fos = new FileOutputStream("daten.s");
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(ben_List);
            os.close();
        } catch (IOException e1){
            System.out.println("Die Datenbank muss erst initialisiert werden!");
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    /**
     * Überprüft ob sich der Benutzer in der Datenhaltung befindet
     * @param benutzer  :Benutzer der überprüft werden soll
     * @return          :True, wenn Benutzer existiert. False, wenn nicht
     */
    public boolean benutzerOk(Benutzer benutzer){
        try {
            FileInputStream fis = new FileInputStream("daten.s");
            ObjectInputStream is = new ObjectInputStream(fis);
            ben_List = (Vector<Benutzer>) is.readObject();
            is.close();
            boolean result = ben_List.contains(benutzer);
            FileOutputStream fos = new FileOutputStream("daten.s");
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(ben_List);
            os.close();
            return result;
        } catch (IOException e1){
            System.out.println("Die Datenbank muss erst initialisiert werden!");
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        }
        return false;
    }

    /**
     * Löscht einen Benutzer aus der Datenhaltung
     * @param benutzer                      :Benutzer der gelöscht werden soll
     * @throws IllegalArgumentException     :Eingegebenes Objekt ist kein Benutzer
     * @throws NullPointerException         :Datenhaltung ist leer
     */
    void benutzerLöschen(Benutzer benutzer) throws IllegalArgumentException,VektorLeerException {
        if(benutzer.passWort.length == 0){
            throw new IllegalArgumentException();
        }
        if(ben_List.isEmpty()){
            throw new VektorLeerException();
        }
        try{
            FileInputStream fis = new FileInputStream("daten.s");
            ObjectInputStream is = new ObjectInputStream(fis);
            ben_List = (Vector<Benutzer>) is.readObject();
            is.close();
            ben_List.remove(benutzer);
            FileOutputStream fos = new FileOutputStream("daten.s");
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(ben_List);
            os.close();
        } catch (IOException e1){
            System.out.println("Die Datenbank muss erst initialisiert werden!");
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    /**
     * Zeigt alle Benutzer in der Datenhaltung
     */
    public void showUsers() {
        for(Benutzer element: ben_List ) {
            System.out.println(element.toString());
        }
    }
}
