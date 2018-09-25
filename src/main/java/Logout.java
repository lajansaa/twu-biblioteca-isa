import java.util.Scanner;

public class Logout implements Page {
    private UserDB userDB;
    private LoggedInUser loggedInUser;
    private Scanner scanner = new Scanner(System.in);

    public Logout(UserDB userDB, LoggedInUser loggedInUser) {
        this.userDB = userDB;
        this.loggedInUser = loggedInUser;
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
            return new Menu(loggedInUser);
        }

        if (userInput.equals("logout")) {
            logUserOut();
            return new Menu(loggedInUser);
        }

        System.out.println("Please select a valid option!");
        return this;
    }

    public Page start() {
        printDescription();

        System.out.println(" ");
        System.out.println("What would you like to do? (logout/back/quit) ");

        String userInput = scanner.nextLine();
        return checkUserInput(userInput);
    }
}
