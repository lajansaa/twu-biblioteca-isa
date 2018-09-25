import java.util.Scanner;

public class ActionAsker {
    private Scanner scanner = new Scanner(System.in);

    public String ask(String prompt) {
        System.out.println(" ");
        System.out.println(prompt);
        return scanner.nextLine().toLowerCase();
    }
}
