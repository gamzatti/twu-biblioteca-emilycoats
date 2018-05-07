package com.twu.biblioteca;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;


public class BookLibraryTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void testSuccessfulCheckout(){
        BookLibrary l = new BookLibrary();
        Book b = new Book("book", 0);
        User u = new User("888-8888", "foo");
        BibliotecaApp.activeUser = u;
        l.availableBooks.add(b);
        l.checkout(b, u);
        assertEquals(BookLibrary.SUCCESSFUL_CHECKOUT, systemOutRule.getLog());
        assertTrue(u.bookCollection.contains(b));
    }


    @Test
    public void testBookIsRemovedFromAvailableBooksAfterCheckout() {
        BookLibrary l = new BookLibrary();
        Book b = new Book("book", 0);
        l.availableBooks.add(b);
        assertTrue(l.availableBooks.contains(b));
        l.checkout(b, BibliotecaApp.activeUser);
        assertFalse(l.availableBooks.contains(b));
    }

    @Test
    public void testUnsuccessfulCheckout(){
        BookLibrary l = new BookLibrary();
        Book b = new Book("book",0);
        l.checkout(b, BibliotecaApp.activeUser);
        assertEquals(BookLibrary.UNSUCCESSFUL_CHECKOUT, systemOutRule.getLog());
    }

    @Test
    public void testSuccessfulReturn(){
        BookLibrary l = new BookLibrary();
        Book b = new Book("Head First Java", 0);
        l.checkedOutBooks.add(b);
        User u = new User("888-8888", "foo");
        u.bookCollection.add(b);
        BibliotecaApp.activeUser = u;
        l.checkin(b, BibliotecaApp.activeUser);
        assertEquals(BookLibrary.SUCCESSFUL_CHECKIN,systemOutRule.getLog());
        assertTrue(l.availableBooks.contains(b));
    }

    @Test
    public void testCanOnlyBeReturnedIfActiveUserHasBorrowedIt(){
        BookLibrary l = new BookLibrary();
        Book b = new Book("Head First Java", 0);
        l.checkedOutBooks.add(b);
        User u = new User("888-8888", "foo");
        BibliotecaApp.activeUser = u;
        l.checkin(b, BibliotecaApp.activeUser);
        assertEquals(BookLibrary.UNSUCCESSFUL_CHECKIN,systemOutRule.getLog());
        assertFalse(l.availableBooks.contains(b));
    }


    @After
    public void restoreBooksToLibrary() {
        BibliotecaApp.bookLibrary = new BookLibrary();
    }

}
