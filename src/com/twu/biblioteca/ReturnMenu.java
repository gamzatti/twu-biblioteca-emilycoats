package com.twu.biblioteca;

import java.util.Scanner;

public class ReturnMenu extends Menu {
    Library library;

    ReturnMenu(Library lib) {
        library = lib;
        instructions = "Type the number of the book you wish to return\n";
    }

    public void display() {
        System.out.print(instructions);
        library.showBooks(library.checkedOutBooks);

    }

    public void respondToSelection() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int chosenNumber = scanner.nextInt();
            library.findAndReturnBook(chosenNumber);
        }
        else if (scanner.next().equals("quit")) {
            BibliotecaApp.quit();
        } else {
            System.out.print(INVALID);
            respondToSelection();
        }
    }
}
