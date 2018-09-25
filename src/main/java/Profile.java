public class Profile implements Page {
    private User user;
    private LoggedInUser loggedInUser;
    private BorrowReturnList borrowReturnList;

    public Profile(User user, LoggedInUser loggedInUser, BorrowReturnList borrowReturnList) {
        this.user = user;
        this.loggedInUser = loggedInUser;
        this.borrowReturnList = borrowReturnList;
    }

    public String getTitle() {
        return "My Profile";
    }

    public void printDescription() {
        System.out.println(" ");
        System.out.println("My Profile");
        System.out.println("----------");
        System.out.println(" ");
    }

    public void printProfile() {
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Number: " + user.getNumber());
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

        System.out.println("Please select a valid option!");
        return this;
    }

    public Page start(ActionAsker actionAsker) {
        printDescription();
        printProfile();
        String userInput = actionAsker.ask("What would you like to do? ");
        return checkUserInput(userInput);
    }

}
