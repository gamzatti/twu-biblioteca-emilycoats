package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

class MovieLibrary extends Library {
    final static String SUCCESSFUL_CHECKOUT =  "Thank you! Enjoy the movie.\n";
    final static String UNSUCCESSFUL_CHECKOUT =  "That movie is not available.\n";
    final static String SUCCESSFUL_CHECKIN = "Thank you for returning the movie.\n";
    final static String UNSUCCESSFUL_CHECKIN = "That is not a valid movie to return.\n";


    void makeSamples() {
        Movie a = new Movie("Movie1", 4);
        Movie b = new Movie("Movie2", 5);
        Movie c = new Movie("Movie3", 6);
        available.addAll(Arrays.asList(a, b, c));
    }

    void checkout(Borrowable movie, User u){
        if (transact(movie, available, checkedOut).equals("successful")){
            u.movieCollection.add((Movie)movie);
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



}