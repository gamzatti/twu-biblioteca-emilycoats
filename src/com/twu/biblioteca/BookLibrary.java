package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

class BookLibrary extends Library {
    final static String SUCCESSFUL_CHECKOUT =  "Thank you! Enjoy the book.\n";
    final static String UNSUCCESSFUL_CHECKOUT =  "That book is not available.\n";
    final static String SUCCESSFUL_CHECKIN = "Thank you for returning the book.\n";
    final static String UNSUCCESSFUL_CHECKIN = "That is not a valid book to return.\n";


    void makeSamples() {
        Book a = new Book("Book1", 1);
        Book b = new Book("Book2", 2);
        Book c = new Book("Book3", 3);
        available.addAll(Arrays.asList(a, b, c));
    }

    void checkout(Borrowable book, User u){
        if (transact(book, available, checkedOut).equals("successful")){
            u.bookCollection.add((Book)book);
            System.out.print(SUCCESSFUL_CHECKOUT);
        }
        else {
            System.out.print(UNSUCCESSFUL_CHECKOUT);
        }
    }

    void checkout(int number, User u) {
        Book selectedBook = (Book) findFromIndex(number, available);
        checkout(selectedBook, u);
    }

    void checkin(Borrowable borrowable, User u) {
        if (u.bookCollection.contains(borrowable) && transact(borrowable, checkedOut, available).equals("successful")){
            System.out.print(SUCCESSFUL_CHECKIN);
        }
        else {
            System.out.print(UNSUCCESSFUL_CHECKIN);
        }
    }



}