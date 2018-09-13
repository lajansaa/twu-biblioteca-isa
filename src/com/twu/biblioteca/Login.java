package com.twu.biblioteca;

public class Login implements MenuOption {
    private Biblioteca bib;

    public Login(Biblioteca bib) {
        this.bib = bib;
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
        bib.getMenu().addMenuOption(profile);
    }

    public void createLogoutMenuOption(User user) {
        Logout logout = new Logout(bib);
        bib.getMenu().addMenuOption(logout);
    }

    public boolean checkCredentials(String userLibraryNumber, String userPassword) {
        for (User user : bib.getUserList()) {
            if (isValidCredentials(user, userLibraryNumber, userPassword)) {
                createProfileMenuOption(user);
                createLogoutMenuOption(user);
                bib.setLoggedInUser(user);
                return false;
            }
        }
        System.out.println(" ");
        System.out.println("Invalid credentials!");
        return true;
    }

    public boolean getCredentials() {
        Helper helper = new Helper();
        System.out.println("Please enter the following:");
        String userLibraryNumber = helper.getUserInput("Library Number (xxx-xxxx): ");
        String userPassword = helper.getUserInput("Password: ");
        return checkCredentials(userLibraryNumber, userPassword);
    }

    public String start() {
        boolean running = true;
        String userInput = null;

        while (running) {
            printDescription();

            Helper helper = new Helper();
            userInput = helper.getUserInput("What would you like to do? (login/back/quit)").toLowerCase();

            running = checkUserInput(userInput);

        }
        return userInput;
    }
}
