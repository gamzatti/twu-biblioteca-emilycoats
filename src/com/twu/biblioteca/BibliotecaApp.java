package com.twu.biblioteca;

class BibliotecaApp {
    final static String WELCOME = "Welcome to Biblioteca\nType 'quit' at any time to exit the program\n";
    static Library library = new Library();

    public static void main(String[] args){
        BibliotecaApp.start();
    }

    private static void start() {
        System.out.print(WELCOME);
        showMainMenu();
    }

    private static void showMainMenu() {
        MainMenu m = new MainMenu();
        m.display();
        m.respondToSelection();
    }

    static void quit() {
        System.exit(0);
    }

    static void showBorrowMenu() {
        BorrowMenu bm = new BorrowMenu(library);
        bm.display();
        bm.respondToSelection();
    }

    static void showReturnMenu() {
        ReturnMenu rm = new ReturnMenu(library);
        rm.display();
        rm.respondToSelection();
    }

}


