package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class BookLibrary {
    HashMap<String, ArrayList<Book>> available = new HashMap<String, ArrayList<Book>>();
    ArrayList<Book> availableBooks;
//    ArrayList<Book> availableMovies;
    ArrayList<Book> checkedOutBooks;
    final static String SUCCESSFUL_CHECKOUT =  "Thank you! Enjoy the book.\n";
    final static String UNSUCCESSFUL_CHECKOUT =  "That book is not available.\n";
    final static String SUCCESSFUL_CHECKIN = "Thank you for returning the book.\n";
    final static String UNSUCCESSFUL_CHECKIN = "That is not a valid book to return.\n";


    BookLibrary() {
        availableBooks = new ArrayList<Book>();
//        availableMovies = new ArrayList<Book>();
        available.put("book", availableBooks);
//        available.put("movie", availableMovies);
        checkedOutBooks = new ArrayList<Book>();
        makeSamples();
    }

    private void makeSamples() {
        Book b1 = new Book("Book1", 1);
        Book b2 = new Book("Book2", 2);
        Book b3 = new Book("Book3", 3);
        availableBooks.addAll(Arrays.asList(b1, b2, b3));
//        Book m1 = new Book("Movie1", 1);
//        Book m2 = new Book("Movie2", 2);
//        Book m3 = new Book("Movie3", 3);
//        availableMovies.addAll(Arrays.asList(m1, m2, m3));
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
            u.bookCollection.add(book);
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

    void checkin(Book book, User u) {
        if (u.bookCollection.contains(book) && transact(book, checkedOutBooks, availableBooks).equals("successful")){
            System.out.print(SUCCESSFUL_CHECKIN);
        }
        else {
            System.out.print(UNSUCCESSFUL_CHECKIN);
        }
    }

    void checkin(int number, User u) {
        Book selectedBook = findFromIndex(number, checkedOutBooks);
        checkin(selectedBook, u);
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