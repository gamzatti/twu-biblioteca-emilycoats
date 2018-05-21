package com.twu.biblioteca;

import java.util.Scanner;

public class ReturnMenu extends Menu {
    private BookLibrary bl;
    private MovieLibrary ml;
    private String borrowableType;

    ReturnMenu(BookLibrary bl, BibliotecaApp bibliotecaApp) {
        this.bibliotecaApp = bibliotecaApp;
        this.bl = bl;
        instructions = "Type the number of the book you wish to return\n";
        borrowableType = "book";
    }

    ReturnMenu(MovieLibrary ml, BibliotecaApp bibliotecaApp) {
        this.bibliotecaApp = bibliotecaApp;
        this.ml = ml;
        instructions = "Type the number of the movie you wish to return\n";
        borrowableType = "movie";
    }

    public void display() {
        super.display();
        try {
            if (borrowableType.equals("book")) {
                bl.show(bibliotecaApp.activeUser.bookCollection);
            }
            else {
                ml.show(bibliotecaApp.activeUser.movieCollection);
            }
        }
        catch (NullPointerException e) {
//            System.out.println("No user is logged in");
        }
    }

    public void respond() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int chosenNumber = scanner.nextInt();
            if (borrowableType.equals("book")) {
                bl.checkin(chosenNumber, bibliotecaApp.activeUser);
            }
            else {
                ml.checkin(chosenNumber, bibliotecaApp.activeUser);
            }
        }
        else {
            respondToQuitOrInvalid(scanner.next());
        }
    }
}
