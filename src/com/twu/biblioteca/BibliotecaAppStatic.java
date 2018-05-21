//package com.twu.biblioteca;
//
//class BibliotecaAppStatic {
//    final static String WELCOME = "Welcome to Biblioteca\n";
//    static BookLibrary bl = new BookLibrary();
//    static MovieLibrary ml = new MovieLibrary();
//    static Authenticator authenticator = new Authenticator();
//    static User activeUser;
//
//
//    public static void main(String[] args){
//        BibliotecaAppStatic.start();
//    }
//
//    private static void start() {
//        System.out.print(WELCOME);
//        showAuthentication();
//    }
//
//    static void showAuthentication() {
//        User user = BibliotecaAppStatic.authenticator.getCredentials();
//        if (authenticator.isSuccess()) {
//            BibliotecaAppStatic.activeUser = user;
//            showMainMenu();
//        }
//        else {
//            System.out.println(authenticator.INVALID);
//            authenticator.getCredentials();
//        }
//    }
//
//    private static void showMainMenu() {
//        MainMenu m = new MainMenu();
//        m.display();
//        m.respond();
//    }
//
//    static void quit() {
//
//        System.exit(0);
//
//    }
//
//    static void showBorrowMenu(String bookOrMovie) {
//        BorrowMenu bm;
//        if (bookOrMovie.equals("book")) {
//            bm = new BorrowMenu(bl);
//        }
//        else {
//            bm = new BorrowMenu(ml);
//        }
//        bm.display();
//        bm.respond();
//    }
//
//    static void showReturnMenu(String bookOrMovie) {
//        ReturnMenu rm;
//        if (bookOrMovie.equals("book")) {
//            rm = new ReturnMenu(bl);
//        }
//        else {
//            rm = new ReturnMenu(ml);
//        }
//        rm.display();
//        rm.respond();
//    }
//
//}
//
//
