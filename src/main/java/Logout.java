import java.util.Scanner;

public class Logout implements MenuOption {
    private Menu menu;
    private UserDB userDB;
    private LoggedInUser loggedInUser;
    private Scanner scanner = new Scanner(System.in);

    public Logout(UserDB userDB, Menu menu, LoggedInUser loggedInUser) {
        this.menu = menu;
        this.userDB = userDB;
        this.loggedInUser = loggedInUser;
    }

    public String getMenuOptionTitle() {
        return "Logout";
    }

    public void printDescription() {
        System.out.println(" ");
        System.out.println("Logout");
        System.out.println("------");
    }

    public void createLoginMenuOption() {
        Login login = new Login(userDB, menu, loggedInUser);
        menu.addMenuOption(login);
    }

    public void logUserOut() {
        loggedInUser.setLoggedInUser(null);
    }

    public boolean checkUserInput(String userInput) {
        System.out.println(" ");
        if (userInput.equals("quit") || userInput.equals("back")) {
            return false;
        } else if (userInput.equals("logout")) {
            logUserOut();
            createLoginMenuOption();
            return false;
        } else {
            return true;
        }
    }

    public String start() {
        boolean running = true;
        String userInput = null;

        while (running) {
            printDescription();

            System.out.println(" ");
            System.out.println("What would you like to do? (logout/back/quit) ");
            userInput = scanner.nextLine().toLowerCase();

            running = checkUserInput(userInput);

        }
        return userInput;
    }
}
