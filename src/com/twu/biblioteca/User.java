package com.twu.biblioteca;

import java.util.ArrayList;

public class User {
    String libraryNumber;
    String password;
    ArrayList<Book> collection = new ArrayList<Book>();


    User(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }
}
