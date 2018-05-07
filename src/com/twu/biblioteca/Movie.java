package com.twu.biblioteca;

class Movie {
    String name;
    int number;

    Movie(String name, int number) {
        this.name = name;
        this.number = number;
    }

    String format() {
        return(String.format("%d. %s", number, name));
    }


}
