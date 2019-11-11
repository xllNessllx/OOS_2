package com.company;

public class Main{

    public static void main(String[] args) {

        BenutzerVerwaltungAdmin admin = new BenutzerVerwaltungAdmin();
        Benutzer benutzer1 = new Benutzer("default","test");
        Benutzer benutzer2 = new Benutzer();


        admin.benutzerEintragen(benutzer1);
        admin.benutzerEintragen(benutzer2);

        admin.showUsers();

        if(admin.benutzerOk(benutzer2)){
            System.out.println("Benutzer ist ok");
        }

        admin.benutzerLöschen(benutzer1);
        admin.benutzerLöschen(benutzer2);

        admin.showUsers();

        if(!(admin.benutzerOk(benutzer2))){
            System.out.println("Benutzer nicht ok");
        }

        if(!(benutzer1.equals(benutzer2))){
            System.out.println("Benutzer sind ungleich");
        }

        try {
           admin.benutzerLöschen(benutzer1);
        } catch (NullPointerException e1){
            System.out.println("nullptr");
        } catch (IllegalArgumentException e2){
            System.out.println("Falsches Argument");
        }

    }
}
