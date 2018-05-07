package com.twu.biblioteca;

class Movie extends Borrowable{

    Movie(String name, int number) {
        super(name, number);
    }

    String format() {
        return(String.format("%d. %s", number, name));
    }


}
