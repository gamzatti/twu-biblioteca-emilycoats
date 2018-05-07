package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

class MovieLibrary {
    ArrayList<Movie> available;
    ArrayList<Movie> checkedOut;
    final static String SUCCESSFUL_CHECKOUT =  "Thank you! Enjoy the movie.\n";
    final static String UNSUCCESSFUL_CHECKOUT =  "That movie is not available.\n";
    final static String SUCCESSFUL_CHECKIN = "Thank you for returning the movie.\n";
    final static String UNSUCCESSFUL_CHECKIN = "That is not a valid movie to return.\n";


    MovieLibrary() {
        available = new ArrayList<Movie>();
        checkedOut = new ArrayList<Movie>();
        makeSamples();
    }

    private void makeSamples() {
        Movie b1 = new Movie("Movie1", 4);
        Movie b2 = new Movie("Movie2", 5);
        Movie b3 = new Movie("Movie3", 6);
        available.addAll(Arrays.asList(b1, b2, b3));
    }

    void show(ArrayList<Movie> movieList) {
        for (Movie b : movieList) {
            System.out.println(b.format());
        }
    }

    private Movie findFromIndex(int chosenNumber, ArrayList<Movie> movieList) {
        Movie selectedMovie = null;
        for (Movie b : movieList) {
            if (b.number == chosenNumber) {
                selectedMovie = b;
            }
        }
        return selectedMovie;
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
        Movie selectedMovie = findFromIndex(number, available);
        checkout(selectedMovie, u);
    }

    void checkin(Movie movie, User u) {
        if (u.movieCollection.contains(movie) && transact(movie, checkedOut, available).equals("successful")){
            System.out.print(SUCCESSFUL_CHECKIN);
        }
        else {
            System.out.print(UNSUCCESSFUL_CHECKIN);
        }
    }

    void checkin(int number, User u) {
        Movie selectedMovie = findFromIndex(number, checkedOut);
        checkin(selectedMovie, u);
    }


    private String transact(Movie movie, ArrayList<Movie> from, ArrayList<Movie> to){
        if (from.contains(movie)) {
            from.remove(movie);
            to.add(movie);
            return "successful";
        }
        else {
            return "unsuccessful";
        }
    }



}