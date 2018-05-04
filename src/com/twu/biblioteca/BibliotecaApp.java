package com.twu.biblioteca;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BibliotecaApp {
    private final static String WELCOME = "Welcome to Biblioteca\n";
    private final static String MENU = "Main menu. Select from the options below. \n 1. List books";
    private final static String INVALID = "Select a valid option!";

    public static void main(String[] args){}

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
        }
        else {
            System.out.println(INVALID);
        }
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
}

