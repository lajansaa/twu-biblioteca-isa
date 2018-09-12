package com.twu.biblioteca;

public class Profile implements MenuOption {
    private User user;

    public Profile(User user) {
        this.user = user;
    }

    public String getMenuOptionTitle() {
        return "My Profile";
    }

    public void printDescription() {
        System.out.println("My Profile");
        System.out.println("----------");
        System.out.println(" ");
    }

    public boolean checkUserInput(String userInput) {
        if (userInput.equals("q") || userInput.equals("b")) {
            return false;
        } else {
            System.out.println("That's an invalid option!");
            System.out.println(" ");
            return true;
        }
    }

    public void printProfile() {
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Number: " + user.getNumber());
    }

    public boolean start() {

        boolean running = true;

        String userInput = null;

        printDescription();

        while (running) {
            printProfile();

            Helper helper = new Helper();
            userInput = helper.getUserInput("What would you like to do? ").toLowerCase();

            running = checkUserInput(userInput);
        }

        if (userInput.equals("q")) {
            return false;
        } else {
            return true;
        }
    }

}
