package com.twu.biblioteca;

import java.util.Scanner;

public class Login implements MenuOption {
    private Menu menu;
    private UserDB userDB;
    private Scanner scanner = new Scanner(System.in);
    private LoggedInUser loggedInUser;

    public Login(UserDB userDB, Menu menu, LoggedInUser loggedInUser) {
        this.userDB = userDB;
        this.menu = menu;
        this.loggedInUser = loggedInUser;
    }

    public String getMenuOptionTitle() {
        return "Login";
    }

    public void printDescription() {
        System.out.println(" ");
        System.out.println("Login");
        System.out.println("-----");
    }

    public boolean checkUserInput(String userInput) {
        System.out.println(" ");
        if (userInput.equals("quit") || userInput.equals("back")) {
            return false;
        } else if (userInput.equals("login")) {
            return getCredentials();
        } else {
            System.out.println("That's an invalid option!");
            return true;
        }
    }

    public boolean isValidCredentials(User user, String userLibraryNumber, String userPassword) {
        return user.getLibraryNumber().equals(userLibraryNumber) && user.getPassword().equals(userPassword);
    }

    public void createProfileMenuOption(User user) {
        Profile profile = new Profile(user);
        menu.addMenuOption(profile);
    }

    public void createLogoutMenuOption() {
        Logout logout = new Logout(userDB, menu, loggedInUser);
        menu.addMenuOption(logout);
    }

    public boolean checkCredentials(String userLibraryNumber, String userPassword) {
        for (User user : userDB.getUserList()) {
            if (isValidCredentials(user, userLibraryNumber, userPassword)) {
                createProfileMenuOption(user);
                createLogoutMenuOption();
                loggedInUser.setLoggedInUser(user);
                return false;
            }
        }
        System.out.println(" ");
        System.out.println("Invalid credentials!");
        return true;
    }

    public boolean getCredentials() {
        System.out.println("Please enter the following:");
        System.out.println(("Library Number (xxx-xxxx): "));
        String userLibraryNumber = scanner.nextLine();
        System.out.println(("Password: "));
        String userPassword = scanner.nextLine();
        return checkCredentials(userLibraryNumber, userPassword);
    }

    public String start() {
        boolean running = true;
        String userInput = null;

        while (running) {
            printDescription();

            System.out.println(" ");
            System.out.println("What would you like to do? (login/back/quit) ");
            userInput = scanner.nextLine().toLowerCase();

            running = checkUserInput(userInput);

        }
        return userInput;
    }
}
