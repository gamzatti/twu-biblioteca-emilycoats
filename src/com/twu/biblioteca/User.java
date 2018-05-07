package com.twu.biblioteca;

import java.util.ArrayList;

public class User {
    String libraryNumber;
    String password;
    ArrayList<Book> bookCollection = new ArrayList<Book>();
    ArrayList<Movie> movieCollection = new ArrayList<Movie>();


    User(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }
}
