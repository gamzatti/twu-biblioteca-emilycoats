package com.twu.biblioteca;

public abstract class Menu {
    final static String INVALID = "Select a valid option!\n";
    String instructions;

    public abstract void respondToSelection();

    public void display(){
        System.out.print(instructions);
    }

    void quitOrInvalid(String input){
        if (input.equals("quit")) {
            BibliotecaApp.quit();
        } else {
            System.out.print(INVALID);
            respondToSelection();
        }

    }

}


