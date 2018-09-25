import java.util.Scanner;

public class Logout implements Page {
    private LoggedInUser loggedInUser;
    private Scanner scanner = new Scanner(System.in);
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

    public void logUserOut() {
        loggedInUser.setLoggedInUser(null);
    }

    public Page checkUserInput(String userInput) {
        System.out.println(" ");
        if (userInput.equals("quit")) {
            return null;
        }

        if (userInput.equals("back")) {
            return new Menu(loggedInUser, borrowReturnList);
        }

        if (userInput.equals("logout")) {
            logUserOut();
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
