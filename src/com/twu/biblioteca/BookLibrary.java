package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

class BookLibrary {
    ArrayList<Borrowable> available;
    ArrayList<Borrowable> checkedOut;
    final static String SUCCESSFUL_CHECKOUT =  "Thank you! Enjoy the book.\n";
    final static String UNSUCCESSFUL_CHECKOUT =  "That book is not available.\n";
    final static String SUCCESSFUL_CHECKIN = "Thank you for returning the book.\n";
    final static String UNSUCCESSFUL_CHECKIN = "That is not a valid book to return.\n";


    BookLibrary() {
        available = new ArrayList<Borrowable>();
        checkedOut = new ArrayList<Borrowable>();
        makeSamples();
    }

    private void makeSamples() {
        Book b1 = new Book("Book1", 1);
        Book b2 = new Book("Book2", 2);
        Book b3 = new Book("Book3", 3);
        available.addAll(Arrays.asList(b1, b2, b3));
    }

    void show(ArrayList<Borrowable> borrowableList) {
        for (Borrowable b : borrowableList) {
            System.out.println(b.format());
        }
    }

    private Borrowable findFromIndex(int chosenNumber, ArrayList<Borrowable> borrowableList) {
        Borrowable selectedBorrowable = null;
        for (Borrowable b : borrowableList) {
            if (b.number == chosenNumber) {
                selectedBorrowable = b;
            }
        }
        return selectedBorrowable;
    }

    void checkout(Book book, User u){
        if (transact(book, available, checkedOut).equals("successful")){
            u.bookCollection.add(book);
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

    void checkin(Borrowable book, User u) {
        if (u.bookCollection.contains(book) && transact(book, checkedOut, available).equals("successful")){
            System.out.print(SUCCESSFUL_CHECKIN);
        }
        else {
            System.out.print(UNSUCCESSFUL_CHECKIN);
        }
    }

    void checkin(int number, User u) {
        Borrowable selectedBook = findFromIndex(number, checkedOut);
        checkin(selectedBook, u);
    }


    private String transact(Borrowable book, ArrayList<Borrowable> from, ArrayList<Borrowable> to){
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