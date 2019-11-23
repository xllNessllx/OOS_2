package com.company;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests für die Klasse BenutzerVerwaltungAdmin
 * @see BenutzerVerwaltungAdmin
 */
class BenutzerVerwaltungAdminTest {

    Benutzer benutzer1 = new Benutzer();
    Benutzer benutzer2 = new Benutzer("test","test");
    BenutzerVerwaltungAdmin admin = new BenutzerVerwaltungAdmin();

    @BeforeEach
    public void init(){
        admin.dbInitialisieren();
    }

    @AfterAll
    public static void cleanup(){
        File f = new File("daten.s");
        f.delete();
    }

    @Test
    public void dbInitialisierenTest(){
        admin.dbInitialisieren();
        File f = new File("daten.s");
        assertTrue(f.isFile() && f.canRead());
    }

    @Test
    public void benutzerEintragenTest(){
        admin.benutzerEintragen(benutzer1);
        assertTrue(admin.benutzerOk(benutzer1));
    }

    @Test
    public void benutzerOKTest(){
        admin.benutzerEintragen(benutzer1);
        assertTrue(admin.benutzerOk(benutzer1));
        assertFalse(admin.benutzerOk(benutzer2));
    }

    @Test
    public void benutzerLöschenTest() throws VektorLeerException {
        admin.benutzerEintragen(benutzer1);
        admin.benutzerLöschen(benutzer1);
        assertFalse(admin.benutzerOk(benutzer1));
    }

}