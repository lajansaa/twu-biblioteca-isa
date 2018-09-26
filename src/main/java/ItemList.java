import java.util.ArrayList;

public class ItemList implements Page {
    private ArrayList<Item> itemList = new ArrayList<>();
    private BorrowReturnList borrowReturnList;
    private String itemListName;
    private LoggedInUser loggedInUser;

    public ItemList(String itemListName, LoggedInUser loggedInUser, BorrowReturnList borrowReturnList) {
        this.itemListName = itemListName;
        this.loggedInUser = loggedInUser;
        this.borrowReturnList = borrowReturnList;
    }

    public String getTitle() {
        return "List " + itemListName;
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public BorrowReturnList getBorrowReturnList() { return borrowReturnList; }

    public void addItem(Item item) {
        itemList.add(item);
    }

    public void printList(Display display) {
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
            display.println(output);
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

    public Menu newMenu(LoggedInUser loggedInUser, BorrowReturnList borrowReturnList) {
        return new Menu(loggedInUser, borrowReturnList);
    }

    private Page checkUserInput(String userInput) {
        System.out.println(" ");
        if (userInput.equals("quit")) {
            return null;
        }

        if (userInput.equals("back")) {
            return newMenu(loggedInUser, borrowReturnList);
        }

        if (isBorrowOrReturn(userInput)) {
            borrowReturnList.start(userInput, itemListName, itemList, loggedInUser.getLoggedInUser(), new Display());
            return this;
        }

        System.out.println("Please select a valid option!");
        return this;
    }

    public Page start(ActionAsker actionAsker) {
        printDescription();
        printList(new Display());
        String userInput = actionAsker.ask("What would you like to do? ");
        return checkUserInput(userInput);

    }
}
