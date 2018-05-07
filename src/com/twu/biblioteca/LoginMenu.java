package com.twu.biblioteca;

public class LoginMenu extends Menu {
    boolean success;

    LoginMenu(){
        instructions = "Please enter your library number\n";
    }
    public void respond(){
        success = false;
    }

}
