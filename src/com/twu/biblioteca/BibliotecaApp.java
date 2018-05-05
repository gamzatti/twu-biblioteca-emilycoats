package com.twu.biblioteca;

import java.util.InputMismatchException;
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
        useInput(getInput());
    }

    private static void quit() {
        System.exit(0);
    }

    static void useInput(String words) {
        if (words.equals("quit")) {
            quit();
        }
        else if (words.equals("1")) {
            listBooks();
        }
        else {
            System.out.print(INVALID);
            useInput(getInput());
        }
        mainMenu();
    }

    static String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }


    static void listBooks() {
        System.out.print(BORROWING_INSTRUCTIONS);
        for (Book b : library.availableBooks) {
            System.out.println(String.format("%d. %s", b.number, b.name));
        }
        listenForCheckout();
    }

    private static void listenForCheckout(){
        Scanner scanner = new Scanner(System.in);
        int chosenNumber = scanner.nextInt();
        Book selectedBook = null;
        for (Book b : library.availableBooks) {
            if (b.number == chosenNumber) {
                selectedBook = b;
            }
        }
        library.checkout(selectedBook);
    }

}


