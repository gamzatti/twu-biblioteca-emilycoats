package com.twu.biblioteca;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {
    private final static String WELCOME = "Welcome to Biblioteca\n";
    private final static String MENU = "Main menu. Select from the options below. \n 1. List books";
    private final static String INVALID = "Select a valid option!";
    static Library library = new Library();

    public static void main(String[] args){
        start();
    }

    private static void start() {
        System.out.print(WELCOME);
        System.out.println(MENU);
        useInput(getInput());
    }

    static String welcome() {
        String message = WELCOME;
        System.out.print(message);
        return message;
    }

    private static void quit() {
        System.exit(0);
    }

    static void useInput(String words) {
        if (words.equals("quit")) {
            quit();
        }
        else if (words.equals("1")) {
            System.out.println("Booklist");
            listBooks();
        }
        else {
            System.out.println(INVALID);
            useInput(getInput());
        }
//        menu();
//        useInput(getInput());
    }

    static String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    static String menu() {
        String message = MENU;
        System.out.println(message);
        return message;

    }

    static void listBooks() {
        for (int i=0; i<library.availableBooks.size(); i++) {
            Book b =library.availableBooks.get(i);
            System.out.println(String.format("%d. %s", i+1, b.name));
        }
        listenForCheckout();

    }

    static void listenForCheckout(){
        Scanner scanner = new Scanner(System.in);
        int bookIndex = scanner.nextInt() - 1;
        Book book = library.availableBooks.get(bookIndex);
        library.checkout(book);
    }

}


