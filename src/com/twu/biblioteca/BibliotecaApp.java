package com.twu.biblioteca;

public class BibliotecaApp {
    final String WELCOME = "Welcome to Biblioteca\n";
    BookLibrary bl = new BookLibrary();
    MovieLibrary ml = new MovieLibrary();
    Authenticator authenticator = new Authenticator(this);
    User activeUser;



    void start() {
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
        MainMenu m = new MainMenu(this);
        m.display();
        m.respond();
    }

    void quit() {
        System.exit(0);
    }
    void showBorrowMenu(String bookOrMovie) {
        BorrowMenu bm;
        if (bookOrMovie.equals("book")) {
            bm = new BorrowMenu(bl, this);
        }
        else {
            bm = new BorrowMenu(ml, this);
        }
        bm.display();
        bm.respond();
    }

    void showReturnMenu(String bookOrMovie) {
        ReturnMenu rm;
        if (bookOrMovie.equals("book")) {
            rm = new ReturnMenu(bl, this);
        }
        else {
            rm = new ReturnMenu(ml, this);
        }
        rm.display();
        rm.respond();
    }

}
