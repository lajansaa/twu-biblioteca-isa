public class Biblioteca {

    public static void printWelcomeMessage() {
        System.out.println(" ");
        System.out.println("Welcome to Biblioteca!");
        System.out.println("----------------------");
        System.out.println("There's much you can do here!");
        System.out.println("At any point in time of your session with us, feel free to type back to go to a previous page or type quit to leave.");
    }

    public static void main(String[] args) {
        printWelcomeMessage();

        Page currentOption = new Menu(new LoggedInUser(), new BorrowReturnList());

        while (true) {
            Page newOption = currentOption.start(new ActionAsker());
            if (newOption != null) {
                currentOption = newOption;
            } else {
                break;
            }
        }

        System.out.println("See you again soon!");
    }
}
