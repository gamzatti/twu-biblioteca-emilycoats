package com.twu.biblioteca;

import org.junit.Test;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class MovieLibraryTest {
    private static final String SAMPLE_MOVIELIST = "4. Movie1\n5. Movie2\n6. Movie3\n";
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void testShowAvailableMovies() {
        MovieLibrary ml = new MovieLibrary();
        ml.show(ml.available);
        assertEquals(SAMPLE_MOVIELIST, systemOutRule.getLog());

    }

    @Test
    public void testSuccessfulCheckout(){
        MovieLibrary ml = new MovieLibrary();
        Movie m = new Movie("movie", 0);
        User u = new User("888-8888", "foo");
        BibliotecaApp.activeUser = u;
        ml.available.add(m);
        ml.checkout(m, u);
        assertEquals(MovieLibrary.SUCCESSFUL_CHECKOUT, systemOutRule.getLog());
        assertTrue(u.movieCollection.contains(m));
    }

    @Test
    public void testMovieIsRemovedFromAvailableBooksAfterCheckout() {
        MovieLibrary l = new MovieLibrary();
        Movie m = new Movie("movie10", 0);
        l.available.add(m);
        assertTrue(l.available.contains(m));
        l.checkout(m, BibliotecaApp.activeUser);
        assertFalse(l.available.contains(m));
    }

    @Test
    public void testUnsuccessfulCheckout(){
        MovieLibrary l = new MovieLibrary();
        Movie m= new Movie("movie",0);
        l.checkout(m, BibliotecaApp.activeUser);
        assertEquals(MovieLibrary.UNSUCCESSFUL_CHECKOUT, systemOutRule.getLog());
    }

    @Test
    public void testSuccessfulReturn(){
        MovieLibrary l = new MovieLibrary();
        Movie m= new Movie("Muriel's Wedding", 0);
        l.checkedOut.add(m);
        User u = new User("888-8888", "foo");
        u.movieCollection.add(m);
        BibliotecaApp.activeUser = u;
        l.checkin(m, BibliotecaApp.activeUser);
        assertEquals(MovieLibrary.SUCCESSFUL_CHECKIN,systemOutRule.getLog());
        assertTrue(l.available.contains(m));
    }


    @Test
    public void testCanOnlyBeReturnedIfActiveUserHasBorrowedIt(){
        MovieLibrary l = new MovieLibrary();
        Movie m = new Movie("The Piano", 0);
        l.checkedOut.add(m);
        User u = new User("888-8888", "foo");
        BibliotecaApp.activeUser = u;
        l.checkin(m, BibliotecaApp.activeUser);
        assertEquals(MovieLibrary.UNSUCCESSFUL_CHECKIN,systemOutRule.getLog());
        assertFalse(l.available.contains(m));
    }


}
