package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

class Library {
    ArrayList<Book> availableBooks;
    ArrayList<Book> checkedOutBooks;
    final static String SUCCESSFUL_CHECKOUT =  "Thank you! Enjoy the book.\n";
    final static String UNSUCCESSFUL_CHECKOUT =  "That book is not available.\n";
    final static String SUCCESSFUL_RETURN = "Thank you for returning the book.\n";
    private final static String UNSUCCESSFUL_RETURN = "That is not a valid book to return.\n";


    Library () {
        availableBooks = new ArrayList<Book>();
        checkedOutBooks = new ArrayList<Book>();
        Book b1 = new Book("Book1", 1);
        Book b2 = new Book("Book2", 2);
        Book b3 = new Book("Book3", 3);
        availableBooks.addAll(Arrays.asList(b1, b2, b3));
    }

    void findAndReturnBook(int chosenNumber) {
        Book selectedBook = getBook(chosenNumber, checkedOutBooks);
        returnBook(selectedBook);
    }

    void findAndCheckoutBook(int chosenNumber) {
        Book selectedBook = getBook(chosenNumber, availableBooks);
        checkoutBook(selectedBook);
    }

    void showBooks(ArrayList<Book> bookList) {
        for (Book b : bookList) {
            System.out.println(b.format());
        }
    }

    private Book getBook(int chosenNumber, ArrayList<Book> bookList) {
        Book selectedBook = null;
        for (Book b : bookList) {
            if (b.number == chosenNumber) {
                selectedBook = b;
            }
        }
        return selectedBook;
    }


    void checkoutBook(Book book){
        if (transaction(book, availableBooks, checkedOutBooks)){
            System.out.print(SUCCESSFUL_CHECKOUT);
        }
        else {
            System.out.print(UNSUCCESSFUL_CHECKOUT);
        }
    }

    void returnBook(Book book) {
        if (transaction(book, checkedOutBooks, availableBooks)){
            System.out.print(SUCCESSFUL_RETURN);
        }
        else {
            System.out.print(UNSUCCESSFUL_RETURN);
        }
    }

    private boolean transaction(Book book, ArrayList<Book> from, ArrayList<Book> to){
        if (from.contains(book)) {
            from.remove(book);
            to.add(book);
            return true;
        }
        else {
            return false;
        }
    }

}