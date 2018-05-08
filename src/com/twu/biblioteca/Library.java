package com.twu.biblioteca;

import java.util.ArrayList;

public abstract class Library {
    ArrayList<Borrowable> available;
    ArrayList<Borrowable> checkedOut;

    Library() {
        available = new ArrayList<Borrowable>();
        checkedOut = new ArrayList<Borrowable>();
        makeSamples();
    }

    abstract void makeSamples();

    void show(ArrayList<Borrowable> borrowableList) {
        for (Borrowable b : borrowableList) {
            System.out.println(b.format());
        }
    }

    Borrowable findFromIndex(int chosenNumber, ArrayList<Borrowable> borrowableList) {
        Borrowable selectedBorrowable = null;
        for (Borrowable b : borrowableList) {
            if (b.number == chosenNumber) {
                selectedBorrowable = b;
            }
        }
        return selectedBorrowable;
    }

    abstract void checkout(int number, User u) ;
    abstract void checkin(Borrowable book, User u);


    void checkin(int number, User u) {
        Borrowable selected = findFromIndex(number, checkedOut);
        checkin(selected, u);
    }

    String transact(Borrowable borrowable, ArrayList<Borrowable> from, ArrayList<Borrowable> to){
        if (from.contains(borrowable)) {
            from.remove(borrowable);
            to.add(borrowable);
            return "successful";
        }
        else {
            return "unsuccessful";
        }
    }
}

