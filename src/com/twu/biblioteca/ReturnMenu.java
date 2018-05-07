package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class ReturnMenu extends Menu {
    private Library library;

    ReturnMenu(Library lib) {
        library = lib;
        instructions = "Type the number of the book you wish to return\n";
        ArrayList<Book> bookList = library.checkedOutBooks;
    }

    public void display() {
        super.display();
        library.show(library.checkedOutBooks);
    }

    public void respond() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int chosenNumber = scanner.nextInt();
            library.checkin(chosenNumber);
        }
        else {
            respondToQuitOrInvalid(scanner.next());
        }
    }
}
