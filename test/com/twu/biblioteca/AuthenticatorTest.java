package com.twu.biblioteca;

import org.junit.Test;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import static org.junit.Assert.assertTrue;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class AuthenticatorTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Test
    public void testSuccessfulLogin() {
        systemInMock.provideLines("123-4567","password");
        Authenticator a = new Authenticator();
        a.getCredentials();
        assertTrue(a.success);


    }
}
