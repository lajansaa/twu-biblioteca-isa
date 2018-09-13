package com.twu.biblioteca;

public class Logout implements MenuOption {
    private Biblioteca bib;

    public Logout(Biblioteca bib) {
        this.bib = bib;
    }

    public String getMenuOptionTitle() {
        return "Logout";
    }

    public void printDescription() {
        System.out.println(" ");
        System.out.println("Logout");
        System.out.println("------");
    }

    public void createLoginMenuOption() {
        Login login = new Login(bib);
        bib.getMenu().addMenuOption(login);
    }

    public void logUserOut() {
        bib.getLoggedInUser().setLoginStatus(false);
        bib.setLoggedInUser(null);
    }

    public boolean checkUserInput(String userInput) {
        System.out.println(" ");
        if (userInput.equals("quit") || userInput.equals("back")) {
            return false;
        } else if (userInput.equals("logout")) {
            logUserOut();
            createLoginMenuOption();
            return false;
        } else {
            return true;
        }
    }

    public String start() {
        boolean running = true;
        String userInput = null;

        while (running) {
            printDescription();

            Helper helper = new Helper();
            userInput = helper.getUserInput("What would you like to do? (logout/back/quit)").toLowerCase();

            running = checkUserInput(userInput);

        }
        return userInput;
    }
}
