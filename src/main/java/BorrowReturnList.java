import java.util.ArrayList;

public class BorrowReturnList {
    private ArrayList<Item> borrowedItemList = new ArrayList<>();
    private ArrayList<User> borrowerList = new ArrayList<>();

    private String getAction(String input) {
        return input.replaceAll("(\\D{6})(\\s\\d+)", "$1");
    }

    private int getItemIndex(String input) {
        return Integer.parseInt(input.replaceAll("(\\D{6}\\s)(\\d+)", "$2")) - 1;
    }

    private boolean isItemValid(int index, ArrayList<Item> itemList) {
        return index >= 0 && index < itemList.size();
    }

    private void borrowItem(int itemIndex, String itemListName, ArrayList<Item> itemList, User borrower, Display display) {
        Item toBorrowItem = itemList.get(itemIndex);
        if (!borrowedItemList.contains(toBorrowItem)) {
            borrowedItemList.add(toBorrowItem);
            borrowerList.add(borrower);
            display.println("Thank you! Enjoy the " + itemListName.toLowerCase() + "!");
        } else {
            display.println("That " + itemListName.toLowerCase() + " is not available.");
        }
    }

    private void returnItem(int itemIndex, String itemListName, ArrayList<Item> itemList, User returner, Display display) {
        Item toBorrowItem = itemList.get(itemIndex);
        if (borrowedItemList.contains(toBorrowItem)) {
            int borrowerIndex = borrowedItemList.indexOf(toBorrowItem);
            if (returner == borrowerList.get(borrowerIndex)) {
                borrowerList.remove(borrowerIndex);
                borrowedItemList.remove(borrowerIndex);
                display.println("Thank you for returning the " + itemListName.toLowerCase() + ".");
            } else {
                display.println("You are not the borrower of this book.");
            }
        } else {
            display.println("That is not a valid " + itemListName.toLowerCase() + " to return.");
        }
    }

    public void start(String userInput, String itemListName, ArrayList<Item> itemList, User loggedInUser, Display display) {
        String action = getAction(userInput);
        int itemIndex = getItemIndex(userInput);

        if (loggedInUser == null) {
            display.println("You need to login to borrow or return a book.");
        } else if (isItemValid(itemIndex, itemList)) {
            if (action.equals("borrow")) {
                borrowItem(itemIndex, itemListName, itemList, loggedInUser, display);
            } else {
                returnItem(itemIndex, itemListName, itemList, loggedInUser, display);
            }
        } else {
            display.println("That is not a valid " + itemListName.toLowerCase() + " to borrow or return.");
        }
    }

    public boolean isItemAvailable(Item item) {
        return !borrowedItemList.contains(item);
    }

    public User getBorrower(Item item) {
        int itemIndex = borrowedItemList.indexOf(item);
        return borrowerList.get(itemIndex);
    }
}
