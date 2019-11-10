package com.company;

public interface BenutzerVerwaltung {
    abstract void benutzerEintragen(Benutzer benutzer);
    abstract boolean benutzerOk(Benutzer benutzer);
}
