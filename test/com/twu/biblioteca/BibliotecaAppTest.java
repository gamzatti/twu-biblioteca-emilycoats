package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BibliotecaAppTest {

    @Test
    public void testWelcome() {
        assertEquals("Welcome to Biblioteca", BibliotecaApp.welcome());
    }

    @Test
    public void testQuit() {
        
    }
}