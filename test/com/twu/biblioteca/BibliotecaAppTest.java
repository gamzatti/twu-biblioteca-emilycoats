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
    BibliotecaApp bibliotecaApp = new BibliotecaApp();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();


    @Test
    public void testAppStartsWithLogin(){
        try {Starter.main(new String[0]);}
        catch (NoSuchElementException e) {}
        String expected = bibliotecaApp.WELCOME + "Please enter your library number\n";
        assertEquals(expected, systemOutRule.getLog());

    }

    @Test
    public void testUnsuccessfulLogin() {
        systemInMock.provideLines("123-4999", "ZZZ");
        try {bibliotecaApp.showAuthentication();}
        catch (NoSuchElementException e ){}
        String expected = "Please enter your library number\nPlease enter your password\n" +
                "Sorry, that is not a valid combination\nPlease enter your library number\n";
        assertEquals(expected, systemOutRule.getLog());
    }

    @Test
    public void testBookCanBeBorrowed(){
        systemInMock.provideLines("1");
        bibliotecaApp.activeUser = new User("123-4321", "88");
        bibliotecaApp.showBorrowMenu("book");
        String expected = "Please select an item to borrow by its number from the list below.\n" +
                SAMPLE_BOOKLIST + BookLibrary.SUCCESSFUL_CHECKOUT;
        assertEquals(expected, systemOutRule.getLog());
    }

    @Test
    public void testBookCanBeCheckedIn() {
        systemInMock.provideLines("0");
        bibliotecaApp.activeUser = new User("123-4321", "88");
        Book b = new Book("The Agile Samurai", 0);
        BookLibrary l = bibliotecaApp.bl;
        l.checkedOut.add(b);
        bibliotecaApp.activeUser.bookCollection.add(b);
        String expected = "Type the number of the book you wish to return\n0. The Agile Samurai\n" +
                BookLibrary.SUCCESSFUL_CHECKIN;
        bibliotecaApp.showReturnMenu("book");
        assertEquals(expected, systemOutRule.getLog());
    }

    @Test
    public void testAppHasActiveUser() {
        User user = new User("999-9999", "XYZ");
        bibliotecaApp.authenticator = new Authenticator(bibliotecaApp);
        bibliotecaApp.authenticator.users.add(user);
        systemInMock.provideLines("999-9999","XYZ");
        try {bibliotecaApp.showAuthentication();}
        catch (NoSuchElementException e ){}
        assertEquals(user, bibliotecaApp.activeUser);

    }

    @After
    public void restoreBooksToLibrary() {
        bibliotecaApp.bl = new BookLibrary();
    }
    @After
    public void restoreAuthenticator() { bibliotecaApp.authenticator = new Authenticator(bibliotecaApp);}
}
