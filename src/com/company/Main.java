package com.company;

public class Main{

    public static void main(String[] args) {

        BenutzerVerwaltungAdmin admin = new BenutzerVerwaltungAdmin();
        Benutzer benutzer = new Benutzer("test","test".toCharArray());

        try {
            admin.benutzerEintragen(benutzer);
            admin.benutzerLöschen(benutzer);
            admin.benutzerLöschen(benutzer);


        } catch (NullPointerException e){
            System.out.println("Bier");
        }

    }
}
