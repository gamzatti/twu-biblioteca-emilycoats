package com.twu.biblioteca;

import java.util.Scanner;

public class Authenticator {
    boolean success;
    String instructions;
    String instructions2;

    Authenticator(){
        instructions = "Please enter your library number\n";
        instructions2 = "Please enter your password.\n";
    }

    public void getCredentials(){
        System.out.print(instructions);
        Scanner scanner = new Scanner(System.in);
        String libraryNumber = scanner.next();
        System.out.print(instructions2);
        scanner = new Scanner(System.in);
        String password = scanner.next();
        checkCredentials(libraryNumber, password);
    }

    public void checkCredentials(String libraryNumber, String password) {
        if (password.equals("password")) {
            success = true;
        }

    }
}
