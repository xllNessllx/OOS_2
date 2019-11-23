package com.company;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests für die Klasse BenutzerVerwaltungAdmin
 * @see BenutzerVerwaltungAdmin
 */
class BenutzerVerwaltungAdminTest {

    Benutzer benutzer1 = new Benutzer();
    Benutzer benutzer2 = new Benutzer("test","test");
    BenutzerVerwaltungAdmin admin = new BenutzerVerwaltungAdmin();

    @Test
    public void benutzerEintragenTest(){
        admin.benutzerEintragen(benutzer1);
        assertEquals(admin.benutzerOk(benutzer1),true);
    }

    @Test
    public void benutzerOKTest(){
        admin.benutzerEintragen(benutzer1);
        assertEquals(admin.benutzerOk(benutzer1),true);
        assertEquals(admin.benutzerOk(benutzer2),false);
    }

    @Test
    public void benutzerLöschenTest() throws VektorLeerException {
        admin.benutzerEintragen(benutzer1);
        admin.benutzerLöschen(benutzer1);
        assertEquals(admin.benutzerOk(benutzer1),false);
    }

}