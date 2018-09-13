package com.twu.biblioteca;

import java.util.ArrayList;

public class Menu {
    private ArrayList<MenuOption> list = new ArrayList<MenuOption>();

    public void addMenuOption(MenuOption option) {
        list.add(option);
    }

    public ArrayList<MenuOption> getList() {
        return list;
    }

    public void printMenu() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i).getMenuOptionTitle());
        }
    }

    public void printDescription() {
        System.out.println(" ");
        System.out.println("Menu");
        System.out.println("----");
        System.out.println("Type the number of an action you would like to take:");
        System.out.println(" ");
    }

    public boolean checkWithinRange(String userInput) {
        int userInputInt;
        if (userInput.matches("[0-9]+")) {
            userInputInt = Integer.parseInt(userInput);
            if (userInputInt > 0 && userInputInt <= list.size()) {
                return true;
            }
        }
        return false;
    }

    public void removeMenuOption(String menuOptionName) {
        ArrayList<MenuOption> toRemove = new ArrayList<MenuOption>();
        for (MenuOption menuOption : list) {
            if (menuOption.getMenuOptionTitle().equals(menuOptionName)) {
                toRemove.add(menuOption);
            }
        }
        list.removeAll(toRemove);
    }

    public boolean checkMenuOptionResult(String result) {
        if (result.equals("quit")) {
            return false;
        } else if (result.equals("login")) {
            removeMenuOption("Login");
        } else if (result.equals("logout")) {
            removeMenuOption("My Profile");
            removeMenuOption("Logout");
        }
        return true;
    }

    public boolean checkUserInput(String userInput) {
        if (userInput.equals("quit")) {
            return false;
        } else if (userInput.equals("back")) {
            System.out.println("This is the home page. Please select a valid menu option!");
        } else if (checkWithinRange(userInput)) {
            String result = list.get(Integer.parseInt(userInput) - 1).start();
            return checkMenuOptionResult(result);
        } else {
            System.out.println("Please select a valid option!");
        }
        return true;
    }

    public void start() {
        boolean running = true;

        while (running) {
            printDescription();
            printMenu();

            Helper helper = new Helper();
            String userInput = helper.getUserInput("What would you like to do? ").toLowerCase();

            running = checkUserInput(userInput);
        }
    }
}
