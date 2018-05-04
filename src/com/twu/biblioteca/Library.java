package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

class Library {
    ArrayList<Book> availableBooks;

    Library () {
        availableBooks = new ArrayList<Book>();
        Book b1 = new Book("Book1");
        Book b2 = new Book("Book2");
        Book b3 = new Book("Book3");
        availableBooks.addAll(Arrays.asList(b1, b2, b3));

    }

    void checkout(Book book){
        if (availableBooks.contains(book)) {
            System.out.println("Thank you! Enjoy the book");
            availableBooks.remove(book);
        }
        else {
            System.out.println("That book is not available.");
        }
    }
}