package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class ReturnMenu extends Menu {
    private BookLibrary bookLibrary;

    ReturnMenu(BookLibrary lib) {
        bookLibrary = lib;
        instructions = "Type the number of the book you wish to return\n";
        ArrayList<Book> booklist = bookLibrary.checkedOutBooks;
    }

    public void display() {
        super.display();
        try {
            bookLibrary.show(BibliotecaApp.activeUser.bookCollection);
        }
        catch (NullPointerException e) {
//            System.out.println("No user is logged in");
        }
    }

    public void respond() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int chosenNumber = scanner.nextInt();
            bookLibrary.checkin(chosenNumber, BibliotecaApp.activeUser);
        }
        else {
            respondToQuitOrInvalid(scanner.next());
        }
    }
}
