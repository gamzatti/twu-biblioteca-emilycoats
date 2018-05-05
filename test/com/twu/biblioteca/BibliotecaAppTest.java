package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.util.NoSuchElementException;


public class BibliotecaAppTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void testAppStarts() {
        try { BibliotecaApp.main(new String[0]); }
        catch (NoSuchElementException e) {}
        String expected = BibliotecaApp.WELCOME + BibliotecaApp.MAIN_MENU;
        assertEquals(expected, systemOutRule.getLog());
    }


    @Test
    public void testTypingQuitCausesExit() {
        exit.expectSystemExit();
        systemInMock.provideLines("quit");
        String input = BibliotecaApp.getInput();
        BibliotecaApp.useInput(input);
    }

    @Test
    public void testTyping1ShowsBookList() {
        systemInMock.provideLines("1");
        try { BibliotecaApp.useInput(BibliotecaApp.getInput()); }
        catch (NoSuchElementException e ) {}
        String expected = BibliotecaApp.BORROWING_INSTRUCTIONS +"1. Book1\n2. Book2\n3. Book3\n";
        assertEquals(expected, systemOutRule.getLog());
    }

    @Test
    public void testInvalidOption() {
        systemInMock.provideLines("foo");
        try { BibliotecaApp.useInput(BibliotecaApp.getInput()); }
        catch (NoSuchElementException e) {}
        assertEquals(BibliotecaApp.INVALID, systemOutRule.getLog());
    }


    @Test
    public void testBooksCanBeBorrowed(){
        systemInMock.provideLines("1");
        BibliotecaApp.listBooks();
        String expected = BibliotecaApp.BORROWING_INSTRUCTIONS + "1. Book1\n2. Book2\n3. Book3\n"+Library.SUCCESSFUL;
        assertEquals(expected, systemOutRule.getLog());
    }

//    @Test
//    public void
}
