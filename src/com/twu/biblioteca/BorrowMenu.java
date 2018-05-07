package com.twu.biblioteca;

import org.junit.contrib.java.lang.system.SystemOutRule;

import java.util.Scanner;

public class BorrowMenu extends Menu {
    private BookLibrary bl;
    private MovieLibrary ml;

    BorrowMenu(BookLibrary bl){
        instructions = "Please select an item to borrow by its number from the list below.\n";
        this.bl = bl;
        this.ml = new MovieLibrary();
    }

    public void display(String bookOrMovie){
        super.display();
        if (bookOrMovie.equals("book")) {
            bl.show(bl.availableBooks);
        }
        else if (bookOrMovie.equals("movie")) {
            ml.show(ml.availableMovies);
        }
    }

    public void respond() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int chosenNumber = scanner.nextInt();
            bl.checkout(chosenNumber, BibliotecaApp.activeUser);
        }
        else {
            respondToQuitOrInvalid(scanner.next());
        }
    }
}
