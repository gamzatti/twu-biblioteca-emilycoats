package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args){}

    public static String welcome() {
        String message = new String("Welcome to Biblioteca");
        System.out.print(message);
        return message;
    }

    public static void quit() {
        System.exit(0);
    }

    public static void input(String words) {
        if (words.equals("quit")) {
            quit();
        }
    }
}
