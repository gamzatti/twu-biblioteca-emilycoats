package com.twu.biblioteca;

import java.util.Scanner;

public class MainMenu extends Menu {
    MainMenu(){
        instructions = "Main Menu. Select from the options below. \n 1. List available books\n 2. Return a book\n";
    }
    public void respondToSelection(){
        Scanner scanner = new Scanner(System.in);
        String line = scanner.next();
        if (line.equals("1")) {
            BibliotecaApp.borrowMenu();
        }
        else if (line.equals("2")) {
            BibliotecaApp.returnMenu();
        }
        else if (line.equals("quit")) {
            BibliotecaApp.quit();
        }
        else {
            System.out.print(INVALID);
            respondToSelection();
        }
        System.out.print(instructions);
        respondToSelection();

    }

    public void display(){
        System.out.print(instructions);

    }
}
