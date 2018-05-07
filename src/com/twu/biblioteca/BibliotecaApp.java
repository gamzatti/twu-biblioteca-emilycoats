package com.twu.biblioteca;

class BibliotecaApp {
    final static String WELCOME = "Welcome to Biblioteca\nType 'quit' at any time to exit the program\n";
    static Library library = new Library();
    static Authenticator authenticator = new Authenticator();
    static User activeUser;

    public static void main(String[] args){
        BibliotecaApp.start();
    }

    private static void start() {
        System.out.print(WELCOME);
        showAuthentication();
    }

    public static void showAuthentication() {
        User user = BibliotecaApp.authenticator.getCredentials();
        if (authenticator.success) {
            BibliotecaApp.activeUser = user;
            showMainMenu();
        }
        else {
            System.out.println("Sorry, that is not a valid combination");
            authenticator.getCredentials();
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


