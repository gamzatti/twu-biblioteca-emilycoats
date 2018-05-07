package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

class MovieLibrary extends Library {
    final static String SUCCESSFUL_CHECKOUT =  "Thank you! Enjoy the movie.\n";
    final static String UNSUCCESSFUL_CHECKOUT =  "That movie is not available.\n";
    final static String SUCCESSFUL_CHECKIN = "Thank you for returning the movie.\n";
    final static String UNSUCCESSFUL_CHECKIN = "That is not a valid movie to return.\n";


    MovieLibrary() {
        available = new ArrayList<Borrowable>();
        checkedOut = new ArrayList<Borrowable>();
        makeSamples();
    }

    void makeSamples() {
        Movie b1 = new Movie("Movie1", 4);
        Movie b2 = new Movie("Movie2", 5);
        Movie b3 = new Movie("Movie3", 6);
        available.addAll(Arrays.asList(b1, b2, b3));
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

    void checkout(Movie movie, User u){
        if (transact(movie, available, checkedOut).equals("successful")){
            u.movieCollection.add(movie);
            System.out.print(SUCCESSFUL_CHECKOUT);
        }
        else {
            System.out.print(UNSUCCESSFUL_CHECKOUT);
        }
    }

    void checkout(int number, User u) {
        Movie selectedMovie = (Movie) findFromIndex(number, available);
        checkout(selectedMovie, u);
    }

    void checkin(Borrowable borrowable, User u) {
        if (u.movieCollection.contains(borrowable) && transact(borrowable, checkedOut, available).equals("successful")){
            System.out.print(SUCCESSFUL_CHECKIN);
        }
        else {
            System.out.print(UNSUCCESSFUL_CHECKIN);
        }
    }

    void checkin(int number, User u) {
        Borrowable selectedMovie = findFromIndex(number, checkedOut);
        checkin(selectedMovie, u);
    }


    private String transact(Borrowable borrowable, ArrayList<Borrowable> from, ArrayList<Borrowable> to){
        if (from.contains(borrowable)) {
            from.remove(borrowable);
            to.add(borrowable);
            return "successful";
        }
        else {
            return "unsuccessful";
        }
    }



}