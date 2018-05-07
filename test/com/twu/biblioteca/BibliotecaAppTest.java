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
        String expected = BibliotecaApp.WELCOME +
                "Main Menu. Select from the options below. \n 1. List available books\n 2. Return a book\n";
        assertEquals(expected, systemOutRule.getLog());
    }

    @Test
    public void testAppStartswithLogin(){
        try {BibliotecaApp.main(new String[0]);}
        catch (NoSuchElementException e) {}
        String expected = BibliotecaApp.WELCOME + "Please enter your library number\n";
        assertEquals(expected, systemOutRule.getLog());

    }
    @Test
    public void testBookCanBeBorrowed(){
        systemInMock.provideLines("1");
        BibliotecaApp.showBorrowMenu();
        String expected = "To borrow a book, please select its number from the list below.\n" +
                SAMPLE_BOOKLIST + Library.SUCCESSFUL_CHECKOUT;
        assertEquals(expected, systemOutRule.getLog());
    }

    @Test
    public void testBookCanBeReturned() {
        systemInMock.provideLines("0");
        Book b = new Book("The Agile Samurai", 0);
        Library l = BibliotecaApp.library;
        l.checkedOutBooks.add(b);
        String expected = "Type the number of the book you wish to return\n0. The Agile Samurai\n" +
                Library.SUCCESSFUL_CHECKIN;
        BibliotecaApp.showReturnMenu();
        assertEquals(expected, systemOutRule.getLog());
    }

    @After
    public void restoreBooksToLibrary() {
        BibliotecaApp.library = new Library();
    }
}
