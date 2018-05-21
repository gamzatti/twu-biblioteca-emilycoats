package com.twu.biblioteca;

import java.util.Scanner;

public class BorrowMenu extends Menu {
    private BookLibrary bl;
    private MovieLibrary ml;
    private String borrowableType;

    BorrowMenu(BookLibrary bl){
        instructions = "Please select an item to borrow by its number from the list below.\n";
        this.bl = bl;
        borrowableType = "book";
    }

    BorrowMenu(MovieLibrary ml){
        instructions = "Please select an item to borrow by its number from the list below.\n";
        this.ml = ml;
        borrowableType = "movie";
    }
    public void display(){
        super.display();
        if (borrowableType.equals("book")) {
            bl.show(bl.available);
        }
        else if (borrowableType.equals("movie")) {
            ml.show(ml.available);
        }
    }

    public void respond() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int chosenNumber = scanner.nextInt();
            if (borrowableType.equals("book")) {
                bl.checkout(chosenNumber, BibliotecaAppStatic.activeUser);
            }
            else {
                ml.checkout(chosenNumber, BibliotecaAppStatic.activeUser);
            }
        }
        else {
            respondToQuitOrInvalid(scanner.next());
        }
    }
}
