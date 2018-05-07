package com.twu.biblioteca;

import java.util.Scanner;

public class BorrowMenu extends Menu {
    private Library library;

    BorrowMenu(Library lib){
        instructions = "Please select an item to borrow by its number from the list below.\n";
        library = lib;
    }

    public void display(String bookOrMovie){
        super.display();
        library.show(library.available.get(bookOrMovie));
    }

    public void respond() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int chosenNumber = scanner.nextInt();
            library.checkout(chosenNumber, BibliotecaApp.activeUser);
        }
        else {
            respondToQuitOrInvalid(scanner.next());
        }
    }
}
