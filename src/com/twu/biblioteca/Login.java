package com.twu.biblioteca;

import java.util.ArrayList;

public class Login implements MenuOption {
    private ArrayList<User> userList;
    private Menu menu;

    public Login(ArrayList<User> userList, Menu menu) {
        this.userList = userList;
        this.menu = menu;
    }

    public String getMenuOptionTitle() {
        return "Login";
    }

    public void printDescription() {
        System.out.println("Login");
        System.out.println("-----");
        System.out.println(" ");
    }

    public boolean checkUserInput(String userInput) {
        if (userInput.equals("q") || userInput.equals("b")) {
            return false;
        } else if (userInput.equals("login")) {
            return checkCredentials();
        } else {
            return true;
        }
    }

    public boolean checkCredentials() {
        Helper helper = new Helper();
        System.out.println("Please enter the following:");
        String userLibraryNumber = helper.getUserInput("Library Number (xxx-xxxx): ");
        String userPassword = helper.getUserInput("Password: ");
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getLibraryNumber().equals(userLibraryNumber) && userList.get(i).getPassword().equals(userPassword)) {
                Profile profile = new Profile(userList.get(i));
                menu.addMenuOption(profile);
                System.out.println("Logged in successfully!");
                System.out.println(" ");
                return true;
            }
        }
        return true;
    }


    public boolean start() {

        boolean running = true;

        String userInput = null;

        printDescription();

        while (running) {

            Helper helper = new Helper();
            userInput = helper.getUserInput("What would you like to do? (login/q/b) ").toLowerCase();
            running = checkUserInput(userInput);

        }

        if (userInput.equals("q")) {
            return false;
        } else {
            return true;
        }
    }
}
