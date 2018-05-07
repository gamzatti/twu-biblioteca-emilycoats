package com.twu.biblioteca;

class BibliotecaApp {
    final static String WELCOME = "Welcome to Biblioteca\n";
    static BookLibrary bookLibrary = new BookLibrary();
    static Authenticator authenticator = new Authenticator();
    static User activeUser;

    public static void main(String[] args){
        BibliotecaApp.start();
    }

    private static void start() {
        System.out.print(WELCOME);
        showAuthentication();
    }

    static void showAuthentication() {
        User user = BibliotecaApp.authenticator.getCredentials();
        if (authenticator.isSuccess()) {
            BibliotecaApp.activeUser = user;
            showMainMenu();
        }
        else {
            System.out.println(authenticator.INVALID);
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

    static void showBorrowMenu(String bookOrMovie) {
        BorrowMenu bm = new BorrowMenu(bookLibrary);
        bm.display(bookOrMovie);
        bm.respond();
    }

    static void showReturnMenu() {
        ReturnMenu rm = new ReturnMenu(bookLibrary);
        rm.display();
        rm.respond();
    }

}


