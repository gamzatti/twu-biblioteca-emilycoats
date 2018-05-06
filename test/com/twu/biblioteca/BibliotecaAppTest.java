package com.twu.biblioteca;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.util.NoSuchElementException;



public class BibliotecaAppTest {

    private static final String SAMPLE_BOOKLIST = "1. Book1\n2. Book2\n3. Book3\n";
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
        BibliotecaApp.respondToMainMenuSelection();
    }

    @Test
    public void testTyping1ShowsBookList() {
        systemInMock.provideLines("1");
        try { BibliotecaApp.respondToMainMenuSelection(); }
        catch (NoSuchElementException e ) {}
        String expected = BibliotecaApp.BORROWING_INSTRUCTIONS + SAMPLE_BOOKLIST;
        assertEquals(expected, systemOutRule.getLog());
    }

    @Test
    public void testInvalidOption() {
        systemInMock.provideLines("foo");
        try { BibliotecaApp.respondToMainMenuSelection(); }
        catch (NoSuchElementException e) {}
        assertEquals(BibliotecaApp.INVALID, systemOutRule.getLog());
    }


    @Test
    public void testBooksCanBeBorrowed(){
        systemInMock.provideLines("1");
        BibliotecaApp.borrowMenu();
        String expected = BibliotecaApp.BORROWING_INSTRUCTIONS + SAMPLE_BOOKLIST +Library.SUCCESSFUL;
        assertEquals(expected, systemOutRule.getLog());
    }

    @Test
    public void testQuitFromBookList(){
        exit.expectSystemExit();
        systemInMock.provideLines("quit");
        BibliotecaApp.borrowMenu();

    }

    @Test
    public void testInvalidBookSelection(){
        systemInMock.provideLines("foo");
        try {BibliotecaApp.borrowMenu();}
        catch (NoSuchElementException e) {}
        String expected = BibliotecaApp.BORROWING_INSTRUCTIONS + SAMPLE_BOOKLIST +BibliotecaApp.INVALID;
        assertEquals(expected, systemOutRule.getLog());
    }

    @Test
    public void testReturnOptionOnBookList() {
        try {BibliotecaApp.borrowMenu();}
        catch (NoSuchElementException e) {}
        String expected = BibliotecaApp.BORROWING_INSTRUCTIONS + SAMPLE_BOOKLIST;
        assertEquals(expected, systemOutRule.getLog());
    }

    @Test
    public void testTyping2ReturnsBook() {
        systemInMock.provideLines("2", "0");
        Library l = BibliotecaApp.library;
        Book b = new Book("The Agile Samurai", 0);
        l.checkedOutBooks.add(b);
        String expected = "Type the number of the book you wish to return\n0. The Agile Samurai\n" + Library.SUCCESSFUL_RETURN + BibliotecaApp.MAIN_MENU;
        try {BibliotecaApp.respondToMainMenuSelection();}
        catch (NoSuchElementException e ){}
        assertEquals(expected, systemOutRule.getLog());
    }

    @After
    public void restoreBooksToLibrary() {
        BibliotecaApp.library = new Library();
    }
}
