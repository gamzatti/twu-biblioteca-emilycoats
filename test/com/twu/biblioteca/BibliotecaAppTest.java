package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.SystemOutRule;



public class BibliotecaAppTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void testWelcomePrints() {
        BibliotecaApp.welcome();
        assertEquals("Welcome to Biblioteca\n", systemOutRule.getLog());
    }

    @Test
    public void testMenuPrints() {
        String menuExpected = "Main menu. Select from the options below. \n 1. List books\n";
        BibliotecaApp.menu();
        assertEquals(menuExpected, systemOutRule.getLog());
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