import java.util.ArrayList;
import java.util.Scanner;

public class Menu implements Page {
    private ArrayList<Page> menuList = new ArrayList<>();
    private LoggedInUser loggedInUser;

    public Menu(LoggedInUser loggedInUser) {
        this.loggedInUser = loggedInUser;
        initialise();
    }

    private void initialise() {
        BookList bookList = new BookList(loggedInUser);
        MovieList movieList = new MovieList(loggedInUser);

        addMenuOption(bookList);
        addMenuOption(movieList);
        addLoginOrLogout();

    }

    private void addLoginOrLogout() {
        UserDB userDB = new UserDB();

        if (loggedInUser.getLoggedInUser() == null) {
            Login login = new Login(userDB, loggedInUser);
            addMenuOption(login);
        } else {
            Logout logout = new Logout(userDB, loggedInUser);
            Profile profile = new Profile(loggedInUser.getLoggedInUser(), loggedInUser);
            addMenuOption(profile);
            addMenuOption(logout);
        }
    }

    private void printList() {
        for (int i = 0; i < menuList.size(); i++) {
            System.out.println((i + 1) + ". " + menuList.get(i).getTitle());
        }
    }

    public void printDescription() {
        System.out.println(" ");
        System.out.println("Menu");
        System.out.println("----");
        System.out.println("Type the number of an action you would like to take:");
        System.out.println(" ");
    }

    private boolean checkWithinRange(String userInput, ArrayList<Page> list) {
        int userInputInt;
        if (userInput.matches("[0-9]+")) {
            userInputInt = Integer.parseInt(userInput);
            return userInputInt > 0 && userInputInt <= list.size();
        }
        return false;
    }

    private Page checkUserInput(String userInput) {
        if (userInput.equals("quit")) {
            return null;
        }

        if (userInput.equals("back")) {
            return this;
        }

        if (checkWithinRange(userInput, menuList)) {
            return menuList.get(Integer.parseInt(userInput) - 1);
        }

        System.out.println("Please select a valid option!");
        return this;
    }

    public void addMenuOption(Page option) {
        menuList.add(option);
    }

    public String getTitle() {
        return "Menu";
    }

    public Page start() {
        printDescription();
        printList();

        System.out.println(" ");
        System.out.println("What do you want to do?");
        Scanner scanner = new Scanner(System.in);

        String userInput = scanner.nextLine();
        return checkUserInput(userInput);
    }
}
