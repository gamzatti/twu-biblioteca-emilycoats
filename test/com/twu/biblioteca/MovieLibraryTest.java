package com.twu.biblioteca;

import org.junit.Test;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.assertEquals;
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
        ml.show(ml.availableMovies);
        assertEquals(SAMPLE_MOVIELIST, systemOutRule.getLog());

    }
}
