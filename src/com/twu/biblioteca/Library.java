package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

class Library {
    ArrayList<Book> availableBooks;
    ArrayList<Book> checkedOutBooks;
    final static String SUCCESSFUL =  "Thank you! Enjoy the book.\n";
    final static String UNSUCCESSFUL =  "That book is not available.\n";
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
        BibliotecaApp.library.returnBook(selectedBook);
    }

    void findAndCheckoutBook(int chosenNumber) {
        Book selectedBook = getBook(chosenNumber, availableBooks);
        checkout(selectedBook);
    }

    void showBooks(ArrayList<Book> bookList) {
        for (Book b : bookList) {
            System.out.println(String.format("%d. %s", b.number, b.name));
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

    void checkout(Book book){
        if (availableBooks.contains(book)) {
            System.out.print(SUCCESSFUL);
            availableBooks.remove(book);
            checkedOutBooks.add(book);
        }
        else {
            System.out.print(UNSUCCESSFUL);
        }
    }

    void returnBook(Book book) {
        if (checkedOutBooks.contains(book)) {
            availableBooks.add(book);
            checkedOutBooks.remove(book);
            System.out.print(SUCCESSFUL_RETURN);
        }
        else {
            System.out.print(UNSUCCESSFUL_RETURN);
        }
    }
}