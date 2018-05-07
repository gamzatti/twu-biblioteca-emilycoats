package com.twu.biblioteca;

import org.junit.Test;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class AuthenticatorTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void testCheckCredentials() {
        User user = new User("999-9999", "PASSWORD");
        Authenticator a = new Authenticator();
        a.users.add(user);
        a.checkCredentials("999-9999", "PASSWORD");
        assertTrue(a.isSuccess());
    }

    @Test
    public void testFalseCredentials() {
        Authenticator a = new Authenticator();
        a.checkCredentials("555-5555", "PASSWORD");
        assertFalse(a.isSuccess());
    }

    @Test
    public void testGetCredentials() {
        systemInMock.provideLines("123-4567","password");
        Authenticator a = new Authenticator();
        a.getCredentials();
        assertTrue(a.isSuccess());
    }

    @Test
    public void testQuit() {
        exit.expectSystemExit();
        systemInMock.provideLines("quit");
        Authenticator a = new Authenticator();
        try {a.getCredentials();}
        catch (NoSuchElementException e) {}
    }


}
