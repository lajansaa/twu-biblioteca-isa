import java.util.ArrayList;

public class Menu implements Page {
    private ArrayList<Page> menuList = new ArrayList<>();
    private LoggedInUser loggedInUser;
    private BorrowReturnList borrowReturnList;

    public Menu(LoggedInUser loggedInUser, BorrowReturnList borrowReturnList) {
        this.loggedInUser = loggedInUser;
        this.borrowReturnList = borrowReturnList;
        initialise();
    }

    private void initialise() {
        BookList bookList = new BookList(loggedInUser, borrowReturnList);
        MovieList movieList = new MovieList(loggedInUser, borrowReturnList);

        addMenuOption(bookList);
        addMenuOption(movieList);
        addLoginOrLogout();
    }

    private void addLoginOrLogout() {
        UserDB userDB = new UserDB();

        if (loggedInUser.getLoggedInUser() == null) {
            Login login = new Login(userDB, loggedInUser, borrowReturnList);
            addMenuOption(login);
        } else {
            Logout logout = new Logout(loggedInUser, borrowReturnList);
            Profile profile = new Profile(loggedInUser.getLoggedInUser(), loggedInUser, borrowReturnList);
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

    public Page start(ActionAsker actionAsker) {
        printDescription();
        printList();

        String userInput = actionAsker.ask("What do you want to do? ");
        return checkUserInput(userInput);
    }
}
