package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Authenticator {
    boolean success = false;
    HashMap<String, String> instructions = new HashMap<String, String>();
    ArrayList<User> users = new ArrayList<User>();


    Authenticator(){
        instructions.put("libraryNumber", "Please enter your library number\n");
        instructions.put("password", "Please enter your password\n");
        User user1 = new User("123-4567", "password");
        users.add(user1);

    }

    public void getCredentials(){
        String libraryNumber = getCredential("libraryNumber");
        String password = getCredential("password");
        checkCredentials(libraryNumber, password);
    }


    private String getCredential(String libraryNumberOrPassword) {
        System.out.print(instructions.get(libraryNumberOrPassword));
        Scanner scanner = new Scanner(System.in);
        return scanner.next();

    }

    public void checkCredentials(String libraryNumber, String password) {
        for (User user : users) {
            if (user.libraryNumber.equals(libraryNumber) && user.password.equals(password)){
                success = true;
                break;
            }
        }

    }
}
