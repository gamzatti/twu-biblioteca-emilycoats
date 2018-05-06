package com.twu.biblioteca;

class BibliotecaApp {
    final static String WELCOME = "Welcome to Biblioteca\nType 'quit' at any time to exit the program\n";
    static Library library = new Library();

    public static void main(String[] args){
        new BibliotecaApp().start();
    }

    private static void mainMenu() {
        MainMenu m = new MainMenu();
        m.display();
        m.respondToSelection();
    }

    static void quit() {
        System.exit(0);
    }

    static void borrowMenu() {
        BorrowMenu bm = new BorrowMenu(library);
        bm.display();
        bm.respondToSelection();
    }

    static void returnMenu() {
        ReturnMenu rm = new ReturnMenu(library);
        rm.display();
        rm.respondToSelection();
    }

    private void start() {
        System.out.print(WELCOME);
        mainMenu();
    }
}


