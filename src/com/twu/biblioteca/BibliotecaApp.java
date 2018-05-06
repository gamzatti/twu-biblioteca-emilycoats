package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {
    final static String WELCOME = "Welcome to Biblioteca\nType 'quit' at any time to exit the program\n";
    final static String MAIN_MENU = "Main Menu. Select from the options below. \n 1. List available books\n";
    final static String INVALID = "Select a valid option!\n";
    final static String BORROWING_INSTRUCTIONS = "To borrow a book, please select its number from the list below, " +
            "or select R to return a book.\n";
    private final static String RETURN_BOOK = "R. Return book\n";
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
        if (line.equals("quit")) {
            quit();
        }
        else if (line.equals("1")) {
            listAvailableBooks();
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

    static void listAvailableBooks() {
        System.out.print(BORROWING_INSTRUCTIONS);
        library.showBooks(library.availableBooks);
        System.out.print(RETURN_BOOK);
        respondToBookSelection();
    }

    private static void listCheckedOutBooks() {
        library.showBooks(library.checkedOutBooks);
    }

    private static void respondToBookSelection(){
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int chosenNumber = scanner.nextInt();
            library.findAndCheckoutBook(chosenNumber);
        }
        else {
            String line = scanner.next();
            if (line.equals("R")) {
                respondToReturnBookSelection(scanner);
            } else if (line.equals("quit")) {
                quit();
            } else {
                System.out.print(INVALID);
                respondToBookSelection();
            }
        }
    }

    private static void respondToReturnBookSelection(Scanner scanner) {
        System.out.print("Type the number of the book you wish to return\n");
        listCheckedOutBooks();
        if (scanner.hasNextInt()) {
            int chosenNumber = scanner.nextInt();
            library.findAndReturnBook(chosenNumber);
        }
        else if (scanner.next().equals("quit")) {
            quit();
        } else {
            System.out.print(INVALID);
            scanner = new Scanner(System.in);
            BibliotecaApp bib = new BibliotecaApp();
            respondToReturnBookSelection(scanner);
        }
    }

}


