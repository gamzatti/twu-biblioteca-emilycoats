package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args){}

    static String welcome() {
        String message = new String("Welcome to Biblioteca\n");
        System.out.print(message);
        return message;
    }

    static void quit() {
        System.exit(0);
    }

    static void input(String words) {
        if (words.equals("quit")) {
            quit();
        }
    }

    static String menu() {
        String message = "Main menu. Select from the options below. \n 1. List books";
        System.out.println(message);
        return message;

    }
}

