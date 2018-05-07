package com.twu.biblioteca;

class Book extends Borrowable {
    Book(String name, int number) {
        super(name, number);
    }

    String format() {
        return(String.format("%d. %s", number, name));
    }


}
