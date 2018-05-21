package com.twu.biblioteca;

import java.util.Scanner;

public class MainMenu extends Menu {

    MainMenu(){
        instructions = "Main Menu. Select from the options below.\n 1. List available books\n 2. List available movies\n 3. Return a book\n 4. Return a movie\n";
    }

    public void respond(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        if (input.equals("1")) {
            BibliotecaAppStatic.showBorrowMenu("book");
        }
        else if (input.equals("2")) {
            BibliotecaAppStatic.showBorrowMenu("movie");
        }
        else if (input.equals("3")) {
            BibliotecaAppStatic.showReturnMenu("book");
        }
        else if (input.equals("4")) {
            BibliotecaAppStatic.showReturnMenu("movie");
        }

        else {
            respondToQuitOrInvalid(input);
        }
        display();
        respond();

    }

}
