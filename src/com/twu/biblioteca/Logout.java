package com.twu.biblioteca;

import java.util.Scanner;

public class Logout implements MenuOption {
    private Biblioteca bib;
    private UserDB userDB;
    private Scanner scanner = new Scanner(System.in);

    public Logout(Biblioteca bib, UserDB userDB) {
        this.bib = bib;
        this.userDB = userDB;
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
        Login login = new Login(bib, userDB);
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

            System.out.println(" ");
            System.out.println("What would you like to do? (logout/back/quit) ");
            userInput = scanner.nextLine().toLowerCase();

            running = checkUserInput(userInput);

        }
        return userInput;
    }
}
