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
    private static final String SAMPLE_BOOK_LIST = "1. Book1\n2. Book2\n3. Book3\n";
    private static final String SAMPLE_MOVIE_LIST = "4. Movie1\n5. Movie2\n6. Movie3\n";

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
        String expected = "Please select an item to borrow by its number from the list below.\n"
                + SAMPLE_BOOK_LIST;
        assertEquals(expected, systemOutRule.getLog());
    }

    @Test
    public void testtyping2ShowsMoviesMenu() {
        MainMenu m = new MainMenu();
        systemInMock.provideLines("2");
        try { m.respond(); }
        catch (NoSuchElementException e ) {}
        String expected = "Please select an item to borrow by its number from the list below.\n"
                + SAMPLE_MOVIE_LIST;
        assertEquals(expected, systemOutRule.getLog());

    }

    @Test
    public void testTyping3ShowsReturnBookMenu() {
        systemInMock.provideLines("3");
        BookLibrary l = BibliotecaAppStatic.bl;
        MainMenu m = new MainMenu();
        String expected = "Type the number of the book you wish to return\n";
        try {m.respond();}
        catch (NoSuchElementException e ){}
        assertEquals(expected, systemOutRule.getLog());
    }

    @Test
    public void testTyping4ShowsReturnMovieMenu() {
        systemInMock.provideLines("4");
        MovieLibrary ml = BibliotecaAppStatic.ml;
        MainMenu m = new MainMenu();
        String expected = "Type the number of the movie you wish to return\n";
        try {m.respond();}
        catch (NoSuchElementException e ){}
        assertEquals(expected, systemOutRule.getLog());
    }

    @Test
    public void testReturnMenuOnlyDisplaysBooksBorrowedByUser(){
        BookLibrary l = BibliotecaAppStatic.bl;
        ReturnMenu rm = new ReturnMenu(l);
        BibliotecaAppStatic.activeUser = new User("888-8888", "foo");
        Book b = new Book("The Agile Samurai", 0);
        l.checkedOut.add(b);
        rm.display();
        assertEquals("Type the number of the book you wish to return\n",systemOutRule.getLog());
    }

    @Test
    public void testReturnMenuDisplaysMoviesBorrowedByUser(){
        BibliotecaAppStatic.activeUser = new User("888-8888", "foo");
        MovieLibrary ml = BibliotecaAppStatic.ml;
        ReturnMenu rm = new ReturnMenu(ml);
        Movie m= new Movie("Foo", 0);
        ml.available.add(m);
        ml.checkout(m,BibliotecaAppStatic.activeUser);
        rm.display();
        assertEquals("Thank you! Enjoy the movie.\nType the number of the movie you wish to return\n0. Foo\n",systemOutRule.getLog());
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
        BorrowMenu bm = new BorrowMenu(new BookLibrary());
        bm.respond();
    }

    @Test
    public void testInvalidFromBorrowMenu(){
        BorrowMenu bm = new BorrowMenu(BibliotecaAppStatic.bl);
        systemInMock.provideLines("foo");
        try {bm.respond();}
        catch (NoSuchElementException e) {}
        assertEquals(Menu.INVALID, systemOutRule.getLog());
    }

    @Test
    public void testQuitFromReturnMenu() {
        exit.expectSystemExit();
        systemInMock.provideLines("quit");
        ReturnMenu rm = new ReturnMenu(new BookLibrary());
        rm.respond();
    }

    @Test
    public void testInvalidFromReturnMenu(){
        ReturnMenu rm = new ReturnMenu(BibliotecaAppStatic.bl);
        systemInMock.provideLines("foo");
        try {rm.respond();}
        catch (NoSuchElementException e) {}
        assertEquals(Menu.INVALID, systemOutRule.getLog());
    }


    @Test
    public void testMainMenuHasFourOptions() {
        MainMenu mm = new MainMenu();
        mm.display();
        String expected = "Main Menu. Select from the options below.\n 1. List available books\n 2. List available movies\n 3. Return a book\n 4. Return a movie\n";
        assertEquals(expected, systemOutRule.getLog());
    }

    @After
    public void restoreBooksToLibrary() {
        BibliotecaAppStatic.bl = new BookLibrary();
    }

    @After
    public void restoreActiveUser() {
        BibliotecaAppStatic.activeUser= null;
    }

}
