package com.twu.biblioteca;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;


public class LibraryTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void testSuccessfulCheckout(){
        Library l = new Library();
        Book b = new Book("book", 0);
        l.availableBooks.add(b);
        l.checkout(b);
        assertEquals(Library.SUCCESSFUL, systemOutRule.getLog());
    }

    @Test
    public void testBookIsRemovedFromAvailableBooksAfterCheckout() {
        Library l = new Library();
        Book b = new Book("book", 0);
        l.availableBooks.add(b);
        assertTrue(l.availableBooks.contains(b));
        l.checkout(b);
        assertFalse(l.availableBooks.contains(b));
    }

    @Test
    public void testUnsuccessfulCheckout(){
        Library l = new Library();
        Book b = new Book("book",0);
        l.checkout(b);
        assertEquals(Library.UNSUCCESSFUL, systemOutRule.getLog());
    }

    @Test
    public void testSuccessfulReturn(){
        Library l = new Library();
        Book b = new Book("Head First Java", 0);
        l.checkedOutBooks.add(b);
        l.returnBook(b);
        assertEquals(Library.SUCCESSFUL_RETURN,systemOutRule.getLog());
        assertTrue(l.availableBooks.contains(b));
    }



    @After
    public void restoreBooksToLibrary() {
        BibliotecaApp.library = new Library();
    }
}
