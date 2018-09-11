package com.twu.biblioteca;

import java.util.ArrayList;


public class ItemList implements MenuOption {
    private ArrayList<Item> itemList = new ArrayList<Item>();
    private String itemListName;

    public ItemList(String itemListName) {
        this.itemListName = itemListName;
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
            System.out.println(output);
        }
    }

    public void printDescription() {
        System.out.println(itemListName + " List");
        System.out.println("---------");
        System.out.println("To borrow a " + itemListName.toLowerCase() + ", type borrow <" + itemListName.toLowerCase() + " number>. Likewise to return a item, type return <" + itemListName.toLowerCase() + " number>.");
        System.out.println(" ");
    }

    public void borrowItem(int itemIndex) {
        Item item = itemList.get(itemIndex);
        if (item.isAvailable()) {
            item.setAvailability(false);
            System.out.println("Thank you! Enjoy the " + itemListName.toLowerCase() + "!");
        } else {
            System.out.println("That " + itemListName.toLowerCase() + " is not available.");
        }
    }

    public void returnItem(int itemIndex) {
        Item item = itemList.get(itemIndex);
        if (!item.isAvailable()) {
            item.setAvailability(true);
            System.out.println("Thank you for returning the " + itemListName.toLowerCase() + ".");
        } else {
            System.out.println("That is not a valid " + itemListName.toLowerCase() + " to return.");
        }
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

    public boolean checkUserInput(String userInput) {
        System.out.println(" ");
        if (userInput.equals("q") || userInput.equals("b")) {
            return false;
        } else if (isBorrow(userInput)) {
            if (isItemValid(userInput)) {
                int itemIndex = getItemIndex(userInput);
                borrowItem(itemIndex);
            } else {
                System.out.println("That " + itemListName.toLowerCase() + " is not available.");
            }
        } else if (isReturn(userInput)) {
            if (isItemValid(userInput)) {
                int itemIndex = getItemIndex(userInput);
                returnItem(itemIndex);
            } else {
                System.out.println("That is not a valid " + itemListName.toLowerCase() + " to return.");
            }
        } else {
            System.out.println("Select a valid option!");
        }
        System.out.println(" ");
        return true;
    }

    public boolean start() {

        boolean running = true;

        String userInput = null;

        printDescription();

        while (running) {
            printList();

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
