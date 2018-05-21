package com.twu.biblioteca;

import java.util.Scanner;

public class MainMenu extends Menu {


    MainMenu(BibliotecaApp bibliotecaApp){
        this.bibliotecaApp = bibliotecaApp;
        instructions = "Main Menu. Select from the options below.\n 1. List available books\n 2. List available movies\n 3. Return a book\n 4. Return a movie\n";
    }

    public void respond(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        if (input.equals("1")) {
            bibliotecaApp.showBorrowMenu("book");
        }
        else if (input.equals("2")) {
            bibliotecaApp.showBorrowMenu("movie");
        }
        else if (input.equals("3")) {
            bibliotecaApp.showReturnMenu("book");
        }
        else if (input.equals("4")) {
            bibliotecaApp.showReturnMenu("movie");
        }

        else {
            respondToQuitOrInvalid(input);
        }
        display();
        respond();

    }

}
