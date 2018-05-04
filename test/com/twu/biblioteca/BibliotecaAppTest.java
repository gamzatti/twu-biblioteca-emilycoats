package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;


public class BibliotecaAppTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

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
        BibliotecaApp.useInput("quit");
    }

    @Test
    public void testOtherInputDoesNotExit() {
        BibliotecaApp.useInput("foo");
    }

    @Test
    public void testTyping() {
        systemInMock.provideLines("foo");
        assertEquals("foo", BibliotecaApp.getInput());
    }

    @Test
    public void testTypingQuitCausesExit() {
        exit.expectSystemExit();
        systemInMock.provideLines("quit");
        String input = BibliotecaApp.getInput();
        BibliotecaApp.useInput(input);
    }

    @Test
    public void testTyping1ListsBooks() {
        systemInMock.provideLines("1");
        BibliotecaApp.useInput(BibliotecaApp.getInput());
        assertEquals("Booklist\n", systemOutRule.getLog());
    }

    @Test
    public void testInvalidOption() {
        systemInMock.provideLines("foo");
        BibliotecaApp.useInput(BibliotecaApp.getInput());
        assertEquals("Select a valid option!\n", systemOutRule.getLog());
    }
}