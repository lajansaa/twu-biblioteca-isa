public class InvalidAction implements UserAction {
    public boolean execute() {
        System.out.println("Please select a valid option!");
        return true;
    }
}
