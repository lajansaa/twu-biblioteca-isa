import java.util.ArrayList;

public class CheckUserInput {
    private boolean checkWithinRange(String userInput, ArrayList<MenuOption> list) {
        int userInputInt;
        if (userInput.matches("[0-9]+")) {
            userInputInt = Integer.parseInt(userInput);
            return userInputInt > 0 && userInputInt <= list.size();
        }
        return false;
    }

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

    public boolean check(String userInput, Menu menu, Display display) {
        Executor executor = new Executor();
        if (userInput.equals("quit")) {
            return executor.execute(new QuitAction());
        } else if (userInput.equals("back")) {
            return executor.execute(new BackAction());
        } else if (checkWithinRange(userInput, menu.getList())) {
            MenuOption selectedOption = menu.getList().get(Integer.parseInt(userInput) - 1);
            String result = selectedOption.start();
            return checkMenuOptionResult(result, menu);
        } else {
            return executor.execute(new InvalidAction());
        }
    }
}
