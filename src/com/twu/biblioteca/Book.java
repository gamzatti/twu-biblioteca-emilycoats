package com.twu.biblioteca;

class Book {
    String name;
    int number;

    Book(String name, int number) {
        this.name = name;
        this.number = number;
    }

    String format() {
        return(String.format("%d. %s", number, name));
    }


}
