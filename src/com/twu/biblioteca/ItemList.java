package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;


public class ItemList implements MenuOption {
    private ArrayList<Item> itemList = new ArrayList<>();
    private BorrowReturnList borrowReturnList = new BorrowReturnList();
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

    public BorrowReturnList getBorrowReturnList() { return borrowReturnList; }

    public void addItem(Item item) {
        itemList.add(item);
    }

    public void printList() {
        for (int i = 0; i < itemList.size(); i++) {
            String output = (i + 1) + ". ";
            Item item = itemList.get(i);
            output += item.getTitle();
            output += "(" + item.getYear() + "): ";
            output += borrowReturnList.isItemAvailable(item) ? "Available" : "Not Available";
            if (loggedInUser.getLoggedInUser() != null) {
                if (loggedInUser.getLoggedInUser().getRole().equals("librarian") && !borrowReturnList.isItemAvailable(item)) {
                    output += " (Borrowed by: " + borrowReturnList.getBorrower(item).getName() + " - " + borrowReturnList.getBorrower(item).getNumber() + ") ";
                }
            }
            System.out.println(output);
        }
    }

    public void printDescription() {
        System.out.println(" ");
        System.out.println(itemListName + " List");
        System.out.println("---------");
        if (loggedInUser.getLoggedInUser() == null) {
            System.out.println("You need to login to borrow or return a book.");
        } else {
            System.out.println("To borrow a " + itemListName.toLowerCase() + ", type borrow <" + itemListName.toLowerCase() + " number>. Likewise to return a item, type return <" + itemListName.toLowerCase() + " number>.");
        }
        System.out.println(" ");
    }

    public boolean isBorrowOrReturn(String input) {
        return input.matches("borrow \\d+|return \\d+");
    }

    public boolean checkUserInput(String userInput) {
        System.out.println(" ");
        if (userInput.equals("quit") || userInput.equals("back")) {
            return false;
        } else if (isBorrowOrReturn(userInput)) {
            borrowReturnList.start(userInput, itemListName, itemList, loggedInUser.getLoggedInUser());
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
