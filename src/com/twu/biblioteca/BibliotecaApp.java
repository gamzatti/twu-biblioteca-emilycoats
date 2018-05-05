package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {
    final static String WELCOME = "Welcome to Biblioteca\nType 'quit' at any time to exit the program\n";
    final static String MAIN_MENU = "Main Menu. Select from the options below. \n 1. List available books\n";
    final static String INVALID = "Select a valid option!\n";
    final static String BORROWING_INSTRUCTIONS = "To borrow a book, please select its number from the list below.\n";
    static Library library = new Library();

    public static void main(String[] args){
        start();
    }

    private static void start() {
        System.out.print(WELCOME);
        mainMenu();
    }

    static void mainMenu() {
        System.out.print(MAIN_MENU);
        respondToMainMenuSelection();
    }

    static void respondToMainMenuSelection() {
        Scanner scanner = new Scanner(System.in);
        String words = scanner.next();
        if (words.equals("quit")) {
            quit();
        }
        else if (words.equals("1")) {
            listBooks();
        }
        else {
            System.out.print(INVALID);
            respondToMainMenuSelection();
        }
        mainMenu();
    }

    private static void quit() {
        System.exit(0);
    }

    static void listBooks() {
        System.out.print(BORROWING_INSTRUCTIONS);
        for (Book b : library.availableBooks) {
            System.out.println(String.format("%d. %s", b.number, b.name));
        }
        respondToBookSelection();
    }

    private static void respondToBookSelection(){
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int chosenNumber = scanner.nextInt();
            Book selectedBook = null;
            for (Book b : library.availableBooks) {
                if (b.number == chosenNumber) {
                    selectedBook = b;
                }
            }
            library.checkout(selectedBook);
        }
        else if (scanner.next().equals("quit")){
            quit();
        }
        else {
            System.out.print(INVALID);
            respondToBookSelection();
        }
    }

}


