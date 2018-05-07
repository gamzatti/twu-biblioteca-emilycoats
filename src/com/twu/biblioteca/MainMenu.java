package com.twu.biblioteca;

import java.util.Scanner;

public class MainMenu extends Menu {

    MainMenu(){
        instructions = "Main Menu. Select from the options below. \n 1. List available books\n 2. List available movies\n 3. Return a book\n";
    }

    public void respond(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        if (input.equals("1")) {
            BibliotecaApp.showBorrowMenu("book");
        }
        else if (input.equals("2")) {
            BibliotecaApp.showBorrowMenu("movie");
        }
        else if (input.equals("3")) {
            BibliotecaApp.showReturnMenu();
        }
        else {
            respondToQuitOrInvalid(input);
        }
        display();
        respond();

    }

}
