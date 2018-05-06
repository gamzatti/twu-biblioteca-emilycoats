package com.twu.biblioteca;

import java.util.Scanner;

public class BorrowMenu extends Menu {
    Library library;

    BorrowMenu(Library lib){
        instructions = "To borrow a book, please select its number from the list below.\n";
        library = lib;
    }
    public void display(){
        System.out.print(instructions);
        library.showBooks(library.availableBooks);

    }

    public void respondToSelection() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int chosenNumber = scanner.nextInt();
            library.findAndCheckoutBook(chosenNumber);
        }
        else if (scanner.next().equals("quit")) {
            BibliotecaApp.quit();
        } else {
            System.out.print(INVALID);
            respondToSelection();
        }

    }
}
