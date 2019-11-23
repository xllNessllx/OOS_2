package com.company;

import java.io.IOException;

/**
 * Interface für die Benutzerverwaltung
 */
public interface BenutzerVerwaltung {

    /**
     * @see BenutzerVerwaltungAdmin
     */
    abstract void benutzerEintragen(Benutzer benutzer) throws IllegalArgumentException;

    /**
     * @see BenutzerVerwaltungAdmin
     */
    abstract boolean benutzerOk(Benutzer benutzer) throws IllegalArgumentException,VektorLeerException;
}
