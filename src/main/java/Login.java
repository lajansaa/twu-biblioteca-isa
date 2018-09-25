import java.util.Scanner;

public class Login implements Page {
    private UserDB userDB;
    private Scanner scanner = new Scanner(System.in);
    private LoggedInUser loggedInUser;

    public Login(UserDB userDB, LoggedInUser loggedInUser) {
        this.userDB = userDB;
        this.loggedInUser = loggedInUser;
    }

    public String getTitle() {
        return "Login";
    }

    public void printDescription() {
        System.out.println(" ");
        System.out.println("Login");
        System.out.println("-----");
    }

    public Page checkUserInput(String userInput) {
        System.out.println(" ");
        if (userInput.equals("quit")) {
            return null;
        }

        if (userInput.equals("back")) {
            return new Menu(loggedInUser);
        }

        if (userInput.equals("login")) {
            return getCredentials();
        }

        System.out.println("Please select a valid option!");
        return this;
    }

    public boolean isValidCredentials(User user, String userLibraryNumber, String userPassword) {
        return user.getLibraryNumber().equals(userLibraryNumber) && user.getPassword().equals(userPassword);
    }

    public Page checkCredentials(String userLibraryNumber, String userPassword) {
        for (User user : userDB.getUserList()) {
            if (isValidCredentials(user, userLibraryNumber, userPassword)) {
                loggedInUser.setLoggedInUser(user);
                return new Menu(loggedInUser);
            }
        }
        System.out.println(" ");
        System.out.println("Invalid credentials!");
        return this;
    }

    public Page getCredentials() {
        System.out.println("Please enter the following:");
        System.out.println(("Library Number (xxx-xxxx): "));
        String userLibraryNumber = scanner.nextLine();
        System.out.println(("Password: "));
        String userPassword = scanner.nextLine();
        return checkCredentials(userLibraryNumber, userPassword);
    }

    public Page start() {
        printDescription();

        System.out.println(" ");
        System.out.println("What would you like to do? (login/back/quit) ");

        String userInput = scanner.nextLine();
        return checkUserInput(userInput);

    }
}
