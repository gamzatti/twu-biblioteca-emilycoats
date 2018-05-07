package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

class MovieLibrary {
    ArrayList<Movie> availableMovies;
    ArrayList<Movie> checkedOutMovies;
    final static String SUCCESSFUL_CHECKOUT =  "Thank you! Enjoy the movie.\n";
    final static String UNSUCCESSFUL_CHECKOUT =  "That movie is not available.\n";
    final static String SUCCESSFUL_CHECKIN = "Thank you for returning the movie.\n";
    final static String UNSUCCESSFUL_CHECKIN = "That is not a valid movie to return.\n";


    MovieLibrary() {
        availableMovies = new ArrayList<Movie>();
        checkedOutMovies = new ArrayList<Movie>();
        makeSamples();
    }

    private void makeSamples() {
        Movie b1 = new Movie("Movie1", 4);
        Movie b2 = new Movie("Movie2", 5);
        Movie b3 = new Movie("Movie3", 6);
        availableMovies.addAll(Arrays.asList(b1, b2, b3));
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
        if (transact(movie, availableMovies, checkedOutMovies).equals("successful")){
            u.movieCollection.add(movie);
            System.out.print(SUCCESSFUL_CHECKOUT);


        }
        else {
            System.out.print(UNSUCCESSFUL_CHECKOUT);
        }
    }

    void checkout(int number, User u) {
        Movie selectedMovie = findFromIndex(number, availableMovies);
        checkout(selectedMovie, u);
    }

    void checkin(Movie movie, User u) {
        if (u.bookCollection.contains(movie) && transact(movie, checkedOutMovies, availableMovies).equals("successful")){
            System.out.print(SUCCESSFUL_CHECKIN);
        }
        else {
            System.out.print(UNSUCCESSFUL_CHECKIN);
        }
    }

    void checkin(int number, User u) {
        Movie selectedMovie = findFromIndex(number, checkedOutMovies);
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