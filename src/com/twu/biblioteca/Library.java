package com.twu.biblioteca;

import java.util.ArrayList;

class Library {
    ArrayList<Book> availableBooks = new ArrayList<Book>();

    void checkout(Book book){
        if (availableBooks.contains(book)) {
            System.out.println("Thank you! Enjoy the book");
        }
        else {
            System.out.println("That book is not available.");
        }
    }
}