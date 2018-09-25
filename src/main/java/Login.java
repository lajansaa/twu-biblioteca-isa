import java.util.Scanner;

public class Login implements Page {
    private UserDB userDB;
    private Scanner scanner = new Scanner(System.in);
    private LoggedInUser loggedInUser;
    private BorrowReturnList borrowReturnList;

    public Login(UserDB userDB, LoggedInUser loggedInUser, BorrowReturnList borrowReturnList) {
        this.userDB = userDB;
        this.loggedInUser = loggedInUser;
        this.borrowReturnList = borrowReturnList;
    }

    public String getTitle() {
        return "Login";
    }

    public void printDescription() {
        System.out.println(" ");
        System.out.println("Login");
        System.out.println("-----");
    }

    public Menu newMenu(LoggedInUser loggedInUser, BorrowReturnList borrowReturnList) {
        return new Menu(loggedInUser, borrowReturnList);
    }

    private Page checkUserInput(String userInput, ActionAsker actionAsker) {
        System.out.println(" ");
        if (userInput.equals("quit")) {
            return null;
        }

        if (userInput.equals("back")) {
            return newMenu(loggedInUser, borrowReturnList);
        }

        if (userInput.equals("login")) {
            return getCredentials(actionAsker);
        }

        System.out.println("Please select a valid option!");
        return this;
    }

    private boolean isValidCredentials(User user, String userLibraryNumber, String userPassword) {
        return user.getLibraryNumber().equals(userLibraryNumber) && user.getPassword().equals(userPassword);
    }

    private Page checkCredentials(String userLibraryNumber, String userPassword) {
        for (User user : userDB.getUserList()) {
            if (isValidCredentials(user, userLibraryNumber, userPassword)) {
                loggedInUser.setLoggedInUser(user);
                return new Menu(loggedInUser, borrowReturnList);
            }
        }
        System.out.println(" ");
        System.out.println("Invalid credentials!");
        return this;
    }

    private Page getCredentials(ActionAsker actionAsker) {
        actionAsker.ask("Please enter the following:");
        actionAsker.ask("Library Number (xxx-xxxx): ");
        String userLibraryNumber = scanner.nextLine();
        actionAsker.ask(("Password: "));
        String userPassword = scanner.nextLine();
        return checkCredentials(userLibraryNumber, userPassword);
    }

    public Page start(ActionAsker actionAsker) {
        printDescription();
        String userInput = actionAsker.ask("What would you like to do? (login/back/quit) ");
        return checkUserInput(userInput, actionAsker);

    }
}