public class Biblioteca {
    private LoggedInUser loggedInUser = new LoggedInUser();
    private Menu menu = new Menu(loggedInUser);

    public void printWelcomeMessage() {
        System.out.println(" ");
        System.out.println("Welcome to Biblioteca!");
        System.out.println("----------------------");
        System.out.println("There's much you can do here!");
        System.out.println("At any point in time of your session with us, feel free to type back to go to a previous page or type quit to leave.");
    }

    public void start() {
        printWelcomeMessage();
        menu.initialise();
        menu.start(new ActionAsker(), new CheckUserInput(), new Display());
        System.out.println("See you again soon!");
    }
}
