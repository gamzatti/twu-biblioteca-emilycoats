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
        library.showBooks(library.checkedOutBooks);
    }

    public void respondToSelection() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int chosenNumber = scanner.nextInt();
            library.findAndReturnBook(chosenNumber);
        }
        else {
            quitOrInvalid(scanner.next());
        }
    }
}
