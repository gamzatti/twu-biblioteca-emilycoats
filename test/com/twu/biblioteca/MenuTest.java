package com.twu.biblioteca;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.util.NoSuchElementException;


public class MenuTest {
    private static final String SAMPLE_BOOKLIST = "1. Book1\n2. Book2\n3. Book3\n";
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void testTyping1ShowsBorrowMenu() {
        MainMenu m = new MainMenu();
        systemInMock.provideLines("1");
        try { m.respond(); }
        catch (NoSuchElementException e ) {}
        String expected = "To borrow a book, please select its number from the list below.\n"
                + SAMPLE_BOOKLIST;
        assertEquals(expected, systemOutRule.getLog());
    }

    @Test
    public void testTyping2ShowsReturnMenu() {
        systemInMock.provideLines("2");
        Library l = BibliotecaApp.library;
        Book b = new Book("The Agile Samurai", 0);
        MainMenu m = new MainMenu();
        l.checkedOutBooks.add(b);
        String expected = "Type the number of the book you wish to return\n0. The Agile Samurai\n";
        try {m.respond();}
        catch (NoSuchElementException e ){}
        assertEquals(expected, systemOutRule.getLog());
    }

    @Test
    public void testQuitFromMainMenu() {
        exit.expectSystemExit();
        systemInMock.provideLines("quit");
        MainMenu m = new MainMenu();
        m.respond();
    }

    @Test
    public void testInvalidFromMainMenu() {
        MainMenu m = new MainMenu();
        systemInMock.provideLines("foo");
        try { m.respond();}
        catch (NoSuchElementException e) {}
        assertEquals(Menu.INVALID, systemOutRule.getLog());
    }

    @Test
    public void testQuitFromBorrowMenu() {
        exit.expectSystemExit();
        systemInMock.provideLines("quit");
        BorrowMenu bm = new BorrowMenu(new Library());
        bm.respond();
    }

    @Test
    public void testInvalidFromBorrowMenu(){
        BorrowMenu bm = new BorrowMenu(BibliotecaApp.library);
        systemInMock.provideLines("foo");
        try {bm.respond();}
        catch (NoSuchElementException e) {}
        assertEquals(Menu.INVALID, systemOutRule.getLog());
    }

    @Test
    public void testQuitFromReturnMenu() {
        exit.expectSystemExit();
        systemInMock.provideLines("quit");
        ReturnMenu rm = new ReturnMenu(new Library());
        rm.respond();
    }

    @Test
    public void testInvalidFromReturnMenu(){
        ReturnMenu rm = new ReturnMenu(BibliotecaApp.library);
        systemInMock.provideLines("foo");
        try {rm.respond();}
        catch (NoSuchElementException e) {}
        assertEquals(Menu.INVALID, systemOutRule.getLog());
    }


    @After
    public void restoreBooksToLibrary() {
        BibliotecaApp.library = new Library();
    }
}
