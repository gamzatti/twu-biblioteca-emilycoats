package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

class Library {
    ArrayList<Book> availableBooks;
    ArrayList<Book> checkedOutBooks;
    final static String SUCCESSFUL_CHECKOUT =  "Thank you! Enjoy the book.\n";
    final static String UNSUCCESSFUL_CHECKOUT =  "That book is not available.\n";
    final static String SUCCESSFUL_CHECKIN = "Thank you for returning the book.\n";
    private final static String UNSUCCESSFUL_CHECKIN = "That is not a valid book to return.\n";


    Library () {
        availableBooks = new ArrayList<Book>();
        checkedOutBooks = new ArrayList<Book>();
        Book b1 = new Book("Book1", 1);
        Book b2 = new Book("Book2", 2);
        Book b3 = new Book("Book3", 3);
        availableBooks.addAll(Arrays.asList(b1, b2, b3));
    }

    void show(ArrayList<Book> bookList) {
        for (Book b : bookList) {
            System.out.println(b.format());
        }
    }

    private Book findFromIndex(int chosenNumber, ArrayList<Book> bookList) {
        Book selectedBook = null;
        for (Book b : bookList) {
            if (b.number == chosenNumber) {
                selectedBook = b;
            }
        }
        return selectedBook;
    }

    void checkout(Book book, User u){
        if (transact(book, availableBooks, checkedOutBooks).equals("successful")){
            u.collection.add(book);
            System.out.print(SUCCESSFUL_CHECKOUT);


        }
        else {
            System.out.print(UNSUCCESSFUL_CHECKOUT);
        }
    }

    void checkout(int number, User u) {
        Book selectedBook = findFromIndex(number, availableBooks);
        checkout(selectedBook, u);
    }

    void checkin(Book book) {
        if (transact(book, checkedOutBooks, availableBooks).equals("successful")){
            System.out.print(SUCCESSFUL_CHECKIN);
        }
        else {
            System.out.print(UNSUCCESSFUL_CHECKIN);
        }
    }

    void checkin(int number) {
        Book selectedBook = findFromIndex(number, checkedOutBooks);
        checkin(selectedBook);
    }


    private String transact(Book book, ArrayList<Book> from, ArrayList<Book> to){
        if (from.contains(book)) {
            from.remove(book);
            to.add(book);
            return "successful";
        }
        else {
            return "unsuccessful";
        }
    }



}