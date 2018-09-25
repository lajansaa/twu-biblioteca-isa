import sun.rmi.runtime.Log;

import java.util.Scanner;

public class Profile implements Page {
    private User user;
    private LoggedInUser loggedInUser;
    private Scanner scanner = new Scanner(System.in);

    public Profile(User user, LoggedInUser loggedInUser) {
        this.user = user;
        this.loggedInUser = loggedInUser;
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

    public Page checkUserInput(String userInput) {
        System.out.println(" ");
        if (userInput.equals("quit")) {
            return null;
        }

        if (userInput.equals("back")) {
            return new Menu(loggedInUser);
        }

        System.out.println("Please select a valid option!");
        return this;
    }

    public void printProfile() {
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Number: " + user.getNumber());
    }

    public Page start() {
        printDescription();

        printProfile();

        System.out.println(" ");
        System.out.println("What would you like to do? (back/quit) ");

        String userInput = scanner.nextLine();
        return checkUserInput(userInput);

    }

}
