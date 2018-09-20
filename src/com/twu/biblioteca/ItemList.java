package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;


public class ItemList implements MenuOption {
    private ArrayList<Item> itemList = new ArrayList<>();
    private String itemListName;
    private Scanner scanner = new Scanner(System.in);
    private LoggedInUser loggedInUser;

    public ItemList(String itemListName, LoggedInUser loggedInUser) {
        this.itemListName = itemListName;
        this.loggedInUser = loggedInUser;
    }

    public String getMenuOptionTitle() {
        return "List " + itemListName;
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public void addItem(Item item) {
        itemList.add(item);
    }

    public void printList() {
        for (int i = 0; i < itemList.size(); i++) {
            String output = (i + 1) + ". ";
            output += itemList.get(i).getTitle();
            output += "(" + itemList.get(i).getYear() + "): ";
            output += itemList.get(i).isAvailable() ? "Available" : "Not Available";
            if (loggedInUser.getLoggedInUser() != null) {
                if (loggedInUser.getLoggedInUser().getRole().equals("librarian") && !itemList.get(i).isAvailable()) {
                    output += " (Borrowed by: " + itemList.get(i).getBorrower().getName() + " - " + itemList.get(i).getBorrower().getNumber() + ") ";
                }
            }
            System.out.println(output);
        }
    }

    public void printDescription() {
        System.out.println(" ");
        System.out.println(itemListName + " List");
        System.out.println("---------");
        if (isLoggedIn()) {
            System.out.println("You need to login to borrow or return a book.");
        } else {
            System.out.println("To borrow a " + itemListName.toLowerCase() + ", type borrow <" + itemListName.toLowerCase() + " number>. Likewise to return a item, type return <" + itemListName.toLowerCase() + " number>.");
        }
        System.out.println(" ");
    }

    public boolean isBorrow(String input) {
        if (input.matches("borrow \\d+")) {
            return true;
        }
        return false;
    }

    public boolean isReturn(String input) {
        if (input.matches("return \\d+")) {
            return true;
        }
        return false;
    }

    public boolean isLoggedIn() {
        return loggedInUser.getLoggedInUser() == null;
    }

    public boolean isItemValid(String input) {
        int itemNumber = getItemIndex(input);
        if (itemNumber >= 0 && itemNumber < itemList.size()) {
            return true;
        }
        return false;
    }

    public int getItemIndex(String input) {
        return Integer.parseInt(input.replaceAll("(\\D{6}\\s)(\\d+)", "$2")) - 1;
    }

    public void tryBorrow(String userInput) {
        if (isLoggedIn()) {
            System.out.println("You need to login to borrow a book.");
        } else if (isItemValid(userInput)) {
            int itemIndex = getItemIndex(userInput);
            borrowItem(itemIndex);
        } else {
            System.out.println("That " + itemListName.toLowerCase() + " is not available.");
        }
    }

    public void tryReturn(String userInput) {
        if (isLoggedIn()) {
            System.out.println("You need to login to return a book.");
        } else if (isItemValid(userInput)) {
            int itemIndex = getItemIndex(userInput);
            returnItem(itemIndex);
        } else {
            System.out.println("That is not a valid " + itemListName.toLowerCase() + " to return.");
        }
    }

    public void borrowItem(int itemIndex) {
        Item item = itemList.get(itemIndex);
        if (item.isAvailable()) {
            item.setBorrower(loggedInUser.getLoggedInUser());
            item.setAvailability(false);
            System.out.println("Thank you! Enjoy the " + itemListName.toLowerCase() + "!");
        } else {
            System.out.println("That " + itemListName.toLowerCase() + " is not available.");
        }
    }

    public void returnItem(int itemIndex) {
        Item item = itemList.get(itemIndex);
        if (!item.isAvailable()) {
            if (loggedInUser.getLoggedInUser() == item.getBorrower()) {
                item.setBorrower(null);
                item.setAvailability(true);
                System.out.println("Thank you for returning the " + itemListName.toLowerCase() + ".");
            } else {
                System.out.println("You are not the borrower of this book.");
            }
        } else {
            System.out.println("That is not a valid " + itemListName.toLowerCase() + " to return.");
        }
    }

    public boolean checkUserInput(String userInput) {
        System.out.println(" ");
        if (userInput.equals("quit") || userInput.equals("back")) {
            return false;
        } else if (isBorrow(userInput)) {
            tryBorrow(userInput);
        } else if (isReturn(userInput)) {
            tryReturn(userInput);
        } else {
            System.out.println("Select a valid option!");
        }
        System.out.println(" ");
        return true;
    }

    public String start() {
        boolean running = true;
        String userInput = null;

        while (running) {
            printDescription();
            printList();

            System.out.println(" ");
            System.out.println("What would you like to do? ");
            userInput = scanner.nextLine().toLowerCase();

            running = checkUserInput(userInput);
        }

        return userInput;
    }
}
