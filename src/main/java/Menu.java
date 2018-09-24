import java.util.ArrayList;

public class Menu {
    private ArrayList<MenuOption> list = new ArrayList<>();
    private LoggedInUser loggedInUser;

    public Menu (LoggedInUser loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public void initialise() {
        BookList bookList = new BookList(loggedInUser);
        bookList.initialise();

        MovieList movieList = new MovieList(loggedInUser);
        movieList.initialise();

        UserDB userDB = new UserDB();
        userDB.initialise();

        Login login = new Login(userDB, this, loggedInUser);

        addMenuOption(bookList);
        addMenuOption(movieList);
        addMenuOption(login);
    }

    public ArrayList<MenuOption> getList() {
        return list;
    }

    public void printMenu(Display display) {
        for (int i = 0; i < list.size(); i++) {
            display.println((i + 1) + ". " + list.get(i).getMenuOptionTitle());
        }
    }

    public void printDescription() {
        System.out.println(" ");
        System.out.println("Menu");
        System.out.println("----");
        System.out.println("Type the number of an action you would like to take:");
        System.out.println(" ");
    }

    public void addMenuOption(MenuOption option) {
        list.add(option);
    }

    public void removeMenuOption(String menuOptionName) {
        ArrayList<MenuOption> toRemove = new ArrayList<>();
        for (MenuOption menuOption : list) {
            if (menuOption.getMenuOptionTitle().equals(menuOptionName)) {
                toRemove.add(menuOption);
            }
        }
        list.removeAll(toRemove);
    }

    public void start(ActionAsker actionAsker, CheckUserInput checkUserInput, Display display) {
        boolean running = true;

        while (running) {
            printDescription();
            printMenu(new Display());

            System.out.println(" ");
            String userInput = actionAsker.ask("What would you like to do? ");

            running = checkUserInput.check(userInput, this, display);
        }
    }
}
