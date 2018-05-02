package com.twu.biblioteca;

public class BibliotecaApp {
    private final static String WELCOME = "Welcome to Biblioteca\n";
    private final static String MENU = "Main menu. Select from the options below. \n 1. List books";

    public static void main(String[] args){}

    static String welcome() {
        String message = WELCOME;
        System.out.print(message);
        return message;
    }

    private static void quit() {
        System.exit(0);
    }

    static void input(String words) {
        if (words.equals("quit")) {
            quit();
        }
    }

    static String menu() {
        String message = MENU;
        System.out.println(message);
        return message;

    }
}

