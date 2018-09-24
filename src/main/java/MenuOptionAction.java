public class MenuOptionAction implements UserAction {

    private boolean checkMenuOptionResult(String result, Menu menu) {
        if (result.equals("quit")) {
            return false;
        } else if (result.equals("login")) {
            menu.removeMenuOption("Login");
        } else if (result.equals("logout")) {
            menu.removeMenuOption("My Profile");
            menu.removeMenuOption("Logout");
        }
        return true;
    }

    public boolean execute() {
        MenuOption selectedOption = menu.getList().get(Integer.parseInt(userInput) - 1);
        String result = selectedOption.start();
        return checkMenuOptionResult(result, menu);
    }
}
