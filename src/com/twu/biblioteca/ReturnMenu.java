package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class ReturnMenu extends Menu {
    private BookLibrary bl;
    private MovieLibrary ml;
    private String borrowableType;

    ReturnMenu(BookLibrary bl) {
        this.bl = bl;
        instructions = "Type the number of the book you wish to return\n";
        borrowableType = "book";
    }

    ReturnMenu(MovieLibrary ml) {
        this.ml = ml;
        instructions = "Type the number of the book you wish to return\n";
        borrowableType = "book";
    }

    public void display() {
        super.display();
        try {
            bl.show(BibliotecaApp.activeUser.bookCollection);
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
                bl.checkin(chosenNumber, BibliotecaApp.activeUser);
            }
            else {
                ml.checkin(chosenNumber, BibliotecaApp.activeUser);
            }
        }
        else {
            respondToQuitOrInvalid(scanner.next());
        }
    }
}
