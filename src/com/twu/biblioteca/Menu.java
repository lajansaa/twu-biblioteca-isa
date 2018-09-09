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
        int userInputInt = Integer.parseInt(userInput);
        if (userInputInt > 0 && userInputInt <= list.size()) {
            return true;
        } else {
            return false;
        }
    }

    public void start() {
        boolean running = true;

        printDescription();

        while (running) {
            printMenu();

            Helper helper = new Helper();
            String userInput = helper.getUserInput("What would you like to do? ").toLowerCase();

            if (userInput.equals("q")) {
                running = false;
            } else if (userInput.equals("b")) {
                System.out.println("This is the home page. Please select a valid menu option!");
            } else if (checkWithinRange(userInput)) {
                running = list.get(Integer.parseInt(userInput) - 1).start();
            } else {
                System.out.println("Please select a valid option!");
            }
        }
    }
}