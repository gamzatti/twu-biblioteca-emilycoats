package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Authenticator {
    private boolean success = false;
    final HashMap<String, String> instructions = new HashMap<String, String>();
    ArrayList<User> users = new ArrayList<User>();
    final String INVALID = "Sorry, that is not a valid combination";

    Authenticator(){
        instructions.put("libraryNumber", "Please enter your bl number\n");
        instructions.put("password", "Please enter your password\n");
        User sampleUser = new User("123-4567", "password");
        users.add(sampleUser);
    }

    public User getCredentials(){
        String libraryNumber = getCredential("libraryNumber");
        String password = getCredential("password");
        return checkCredentials(libraryNumber, password);
    }

    private String getCredential(String libraryNumberOrPassword) {
        System.out.print(instructions.get(libraryNumberOrPassword));
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        if (input.equals("quit")) {
            BibliotecaApp.quit();
        }
        return input;
    }

    public User checkCredentials(String libraryNumber, String password) {
        for (User user : users) {
            if (user.libraryNumber.equals(libraryNumber) && user.password.equals(password)){
                setSuccess(true);
                return user;
            }
        }
        return null;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
