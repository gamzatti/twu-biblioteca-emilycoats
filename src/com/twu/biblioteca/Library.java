package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

class Library {
    ArrayList<Book> availableBooks;
    final static String SUCCESSFUL =  "Thank you! Enjoy the book.\n";
    final static String UNSUCCESSFUL =  "That book is not available.\n";


    Library () {
        availableBooks = new ArrayList<Book>();
        Book b1 = new Book("Book1", 1);
        Book b2 = new Book("Book2", 2);
        Book b3 = new Book("Book3", 3);
        availableBooks.addAll(Arrays.asList(b1, b2, b3));

    }

    void checkout(Book book){
        if (availableBooks.contains(book)) {
            System.out.print(SUCCESSFUL);
            availableBooks.remove(book);
        }
        else {
            System.out.print(UNSUCCESSFUL);
        }
    }
}