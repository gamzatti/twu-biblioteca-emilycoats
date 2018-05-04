package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.util.Arrays;


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
        Book b = new Book("book");
        l.availableBooks.add(b);
        l.checkout(b);
        assertEquals("Thank you! Enjoy the book\n", systemOutRule.getLog());
    }

    @Test
    public void testBookIsRemovedFromAvailableBooksAfterCheckout() {
        Library l = new Library();
        Book b = new Book("book");
        l.availableBooks.add(b);
        l.checkout(b);
        l.checkout(b);
        assertEquals("Thank you! Enjoy the book\nThat book is not available.\n", systemOutRule.getLog());

    }

    @Test
    public void testUnsuccessfulCheckout(){
        Library l = new Library();
        Book b = new Book("book");
        l.checkout(b);
        assertEquals("That book is not available.\n", systemOutRule.getLog());
    }

    @Test
    public void testListBooks(){
        systemInMock.provideLines("1");
        BibliotecaApp.listBooks();
        assertEquals("1. Book1\n2. Book2\n3. Book3\nThank you! Enjoy the book\n", systemOutRule.getLog());
    }

}
