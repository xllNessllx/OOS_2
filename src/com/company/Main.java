package com.company;

import junit.framework.TestCase;

public class BenutzerTest extends TestCase{
    private Benutzer ben;

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }
}

public class Main{

    public static void main(String[] args) {
        junit.textui.TestRunner.run(BenutzerTest.class);
    }
}
