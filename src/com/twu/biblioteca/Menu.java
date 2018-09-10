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

    public boolean checkUserInput(String userInput) {
        System.out.println(" ");
        if (userInput.equals("q")) {
            return false;
        } else if (userInput.equals("b")) {
            System.out.println("This is the home page. Please select a valid menu option!");
            System.out.println(" ");
            return true;
        } else if (checkWithinRange(userInput)) {
            return list.get(Integer.parseInt(userInput) - 1).start();
        } else {
            System.out.println("Please select a valid option!");
            System.out.println(" ");
            return true;
        }
    }

    public void start() {
        boolean running = true;

        printDescription();

        while (running) {
            printMenu();

            Helper helper = new Helper();
            String userInput = helper.getUserInput("What would you like to do? ").toLowerCase();

            running = checkUserInput(userInput);
        }
    }
}
