package com.company;

import java.util.*;

public class BenutzerVerwaltungAdmin implements BenutzerVerwaltung {

    private Vector<Benutzer> ben_List;

    BenutzerVerwaltungAdmin(){
        ben_List = new Vector<Benutzer>();
    }

    public void benutzerEintragen (Benutzer benutzer) throws NullPointerException {
        ben_List.addElement(benutzer);
    }

    public boolean benutzerOk(Benutzer benutzer){
        return ben_List.contains(benutzer);
    }

    void benutzerLöschen(Benutzer benutzer) throws NullPointerException{
        if(ben_List.isEmpty()){
            throw new NullPointerException();
        }
        ben_List.remove(benutzer);
    }

    public void showUsers() {
        for(Benutzer element: ben_List ) {
            System.out.println(element.toString());
        }
    }
}
