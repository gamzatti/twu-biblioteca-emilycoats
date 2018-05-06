package com.twu.biblioteca;

import java.util.Scanner;

class BibliotecaApp {
    final static String WELCOME = "Welcome to Biblioteca\nType 'quit' at any time to exit the program\n";
    final static String MAIN_MENU = "Main Menu. Select from the options below. \n 1. List available books\n 2. Return a book\n";
    final static String INVALID = "Select a valid option!\n";
    final static String BORROWING_INSTRUCTIONS = "To borrow a book, please select its number from the list below.\n";
    final static String RETURN_INSTRUCTIONS = "Type the number of the book you wish to return\n";
    static Library library = new Library();

    public static void main(String[] args){
        start();
    }

    private static void start() {
        System.out.print(WELCOME);
        mainMenu();
    }

    private static void mainMenu() {
        System.out.print(MAIN_MENU);
        respondToMainMenuSelection();
    }

    static void respondToMainMenuSelection() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.next();
        if (line.equals("1")) {
            borrowMenu();
        }
        else if (line.equals("2")) {
            returnMenu();
        }
        else if (line.equals("quit")) {
            quit();
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

    static void borrowMenu() {
        System.out.print(BORROWING_INSTRUCTIONS);
        library.showBooks(library.availableBooks);
        respondToBorrowMenuSelection();
    }

    private static void respondToBorrowMenuSelection(){
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int chosenNumber = scanner.nextInt();
            library.findAndCheckoutBook(chosenNumber);
        }
        else if (scanner.next().equals("quit")) {
            quit();
        } else {
            System.out.print(INVALID);
            respondToBorrowMenuSelection();
        }
    }

    private static void returnMenu() {
        System.out.print(RETURN_INSTRUCTIONS);
        library.showBooks(library.checkedOutBooks);
        respondToReturnMenuSelection();
    }

    private static void respondToReturnMenuSelection() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int chosenNumber = scanner.nextInt();
            library.findAndReturnBook(chosenNumber);
        }
        else if (scanner.next().equals("quit")) {
            quit();
        } else {
            System.out.print(INVALID);
            respondToReturnMenuSelection();
        }
    }


}


