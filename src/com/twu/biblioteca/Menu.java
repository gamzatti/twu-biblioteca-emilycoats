package com.twu.biblioteca;

public abstract class Menu {
    final static String INVALID = "Select a valid option!\n";
    String instructions;
    BibliotecaApp bibliotecaApp;

    public abstract void respond();

    public void display(){
        System.out.print(instructions);
    }

    void respondToQuitOrInvalid(String input){
        if (input.equals("quit")) {
            bibliotecaApp.quit();
        } else {
            System.out.print(INVALID);
            respond();
        }

    }

}


