package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;




public class BibliotecaAppTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void testWelcome() {
        assertEquals("Welcome to Biblioteca", BibliotecaApp.welcome());
    }

    @Test
    public void testSystemExits() {
        exit.expectSystemExit();
        BibliotecaApp.quit();
    }

    @Test
    public void testInputQuitCausesExit() {
        exit.expectSystemExit();
        BibliotecaApp.input("quit");
    }

    @Test
    public void testOtherInputDoesNotExit() {
        BibliotecaApp.input("foo");
    }
}