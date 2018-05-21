package com.twu.biblioteca;

import java.util.Scanner;

public class MainMenu extends Menu {
    final String BORROW_BOOK = "1";
    final String BORROW_MOVIE = "2";
    final String RETURN_BOOK = "3";
    final String RETURN_MOVIE = "4";

    MainMenu(BibliotecaApp bibliotecaApp){
        this.bibliotecaApp = bibliotecaApp;
        instructions = "Main Menu. Select from the options below.\n 1. List available books\n 2. List available movies\n 3. Return a book\n 4. Return a movie\n";
    }

    public void respond(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        if (input.equals(BORROW_BOOK)) {
            bibliotecaApp.showBorrowMenu("book");
        }
        else if (input.equals(BORROW_MOVIE)) {
            bibliotecaApp.showBorrowMenu("movie");
        }
        else if (input.equals(RETURN_BOOK)) {
            bibliotecaApp.showReturnMenu("book");
        }
        else if (input.equals(RETURN_MOVIE)) {
            bibliotecaApp.showReturnMenu("movie");
        }

        else {
            respondToQuitOrInvalid(input);
        }
        display();
        respond();

    }

}
