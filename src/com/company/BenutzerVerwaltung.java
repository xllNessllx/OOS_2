package com.company;

public interface BenutzerVerwaltung {
    abstract void benutzerEintragen(Benutzer benutzer) throws Exception;
    abstract boolean benutzerOk(Benutzer benutzer);
}
