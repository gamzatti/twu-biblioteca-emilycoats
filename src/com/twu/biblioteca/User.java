package com.twu.biblioteca;

import java.util.ArrayList;

public class User {
    String libraryNumber;
    String password;
    ArrayList<Borrowable> bookCollection = new ArrayList<Borrowable>();
    ArrayList<Borrowable> movieCollection = new ArrayList<Borrowable>();


    User(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }
}
