package com.company;

import java.util.*;

/**
 * Klasse die Benutzer in einer Datenhaltung speichert
 * und diese verwaltet
 */
public class BenutzerVerwaltungAdmin implements BenutzerVerwaltung {

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
     * Fügt der Datenhaltung ein Objekt vom Typ Benutzer hinzu
     * @param benutzer                          :Der Benutzer, der Eingefügt werden soll
     * @throws IllegalArgumentException      :Objekt ist nicht vom Typ Benutzer
     * @throws NullPointerException          :Das Objekt ist NULL
     */
    public void benutzerEintragen (Benutzer benutzer) throws IllegalArgumentException,NullPointerException {
        if(!(benutzer instanceof Benutzer)){
            throw  new IllegalArgumentException();
        }
        if(benutzer == null){
            throw new NullPointerException();
        }
        ben_List.addElement(benutzer);
    }

    /**
     * Überprüft ob sich der Benutzer in der Datenhaltung befindet
     * @param benutzer  :Benutzer der überprüft werden soll
     * @return          :True, wenn Benutzer existiert. False, wenn nicht
     */
    public boolean benutzerOk(Benutzer benutzer){
        return ben_List.contains(benutzer);
    }

    /**
     * Löscht einen Benutzer aus der Datenhaltung
     * @param benutzer                      :Benutzer der gelöscht werden soll
     * @throws IllegalArgumentException     :Eingegebenes Objekt ist kein Benutzer
     * @throws NullPointerException         :Datenhaltung ist leer
     */
    void benutzerLöschen(Benutzer benutzer) throws IllegalArgumentException,NullPointerException {
        if(!(benutzer instanceof Benutzer)){
            throw new IllegalArgumentException();
        }
        if(ben_List.isEmpty()){
            throw new NullPointerException();
        }
        ben_List.remove(benutzer);
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
