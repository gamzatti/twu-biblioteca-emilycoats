package com.twu.biblioteca;

public abstract class Borrowable {
    String name;
    int number;

    Borrowable(String name, int number) {
        this.name = name;
        this.number = number;
    }

    String format() {
        return(String.format("%d. %s", number, name));
    }

}
