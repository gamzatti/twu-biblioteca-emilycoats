package com.twu.biblioteca;

import org.junit.contrib.java.lang.system.SystemOutRule;

import java.util.ArrayList;
import java.util.Scanner;

public class ReturnMenu extends Menu {
    private Library library;

    ReturnMenu(Library lib) {
        library = lib;
        instructions = "Type the number of the book you wish to return\n";
        ArrayList<Book> booklist = library.checkedOutBooks;
    }

    public void display() {
        super.display();
        try {
            library.show(BibliotecaApp.activeUser.collection);
        }
        catch (NullPointerException e) {
//            System.out.println("No user is logged in");
        }
    }

    public void respond() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int chosenNumber = scanner.nextInt();
            library.checkin(chosenNumber, BibliotecaApp.activeUser);
        }
        else {
            respondToQuitOrInvalid(scanner.next());
        }
    }
}
