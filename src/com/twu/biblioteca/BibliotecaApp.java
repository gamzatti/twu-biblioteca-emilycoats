package com.twu.biblioteca;

class BibliotecaApp {
    final static String WELCOME = "Welcome to Biblioteca\nType 'quit' at any time to exit the program\n";
    static Library library = new Library();

    public static void main(String[] args){
        BibliotecaApp.start();
    }

    private static void start() {
        System.out.print(WELCOME);
        showAuthentication();
    }

    public static void showAuthentication() {
        Authenticator a = new Authenticator();
        a.getCredentials();
        if (a.success) {
            showMainMenu();
        }
        else {
            System.out.println("Sorry, that is not a valid combination");
            a.getCredentials();
        }
    }

    private static void showMainMenu() {
        MainMenu m = new MainMenu();
        m.display();
        m.respond();
    }

    static void quit() {
        System.exit(0);
    }

    static void showBorrowMenu() {
        BorrowMenu bm = new BorrowMenu(library);
        bm.display();
        bm.respond();
    }

    static void showReturnMenu() {
        ReturnMenu rm = new ReturnMenu(library);
        rm.display();
        rm.respond();
    }

}


