public class Logout implements Page {
    private LoggedInUser loggedInUser;
    private BorrowReturnList borrowReturnList;

    public Logout(LoggedInUser loggedInUser, BorrowReturnList borrowReturnList) {
        this.loggedInUser = loggedInUser;
        this.borrowReturnList = borrowReturnList;
    }

    public String getTitle() {
        return "Logout";
    }

    public void printDescription() {
        System.out.println(" ");
        System.out.println("Logout");
        System.out.println("------");
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

        if (userInput.equals("logout")) {
            loggedInUser.setLoggedInUser(null);
            return new Menu(loggedInUser, borrowReturnList);
        }

        System.out.println("Please select a valid option!");
        return this;
    }

    public Page start(ActionAsker actionAsker) {
        printDescription();
        String userInput = actionAsker.ask("What would you like to do? (logout/back/quit) ");
        return checkUserInput(userInput);
    }
}
