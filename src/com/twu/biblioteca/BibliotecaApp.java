package com.twu.biblioteca;

public class BibliotecaApp {
    final String WELCOME = "Welcome to Biblioteca\n";
    BookLibrary bl = new BookLibrary();
    MovieLibrary ml = new MovieLibrary();
    Authenticator authenticator = new Authenticator();
    User activeUser;

    public static void main(String[] args){
        BibliotecaApp b = new BibliotecaApp();
        b.start();
    }

    private void start() {
        System.out.print(WELCOME);
        showAuthentication();
    }

    void showAuthentication() {
        User user = authenticator.getCredentials();
        if (authenticator.isSuccess()) {
            activeUser = user;
            showMainMenu();
        }
        else {
            System.out.println(authenticator.INVALID);
            authenticator.getCredentials();
        }
    }
    private void showMainMenu() {
        MainMenu m = new MainMenu();
        m.display();
        m.respond();
    }

    void quit() {
        System.exit(0);
    }
    void showBorrowMenu(String bookOrMovie) {
        BorrowMenu bm;
        if (bookOrMovie.equals("book")) {
            bm = new BorrowMenu(bl);
        }
        else {
            bm = new BorrowMenu(ml);
        }
        bm.display();
        bm.respond();
    }

    void showReturnMenu(String bookOrMovie) {
        ReturnMenu rm;
        if (bookOrMovie.equals("book")) {
            rm = new ReturnMenu(bl);
        }
        else {
            rm = new ReturnMenu(ml);
        }
        rm.display();
        rm.respond();
    }

}
