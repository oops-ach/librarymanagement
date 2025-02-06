package menu.options;

import menu.MenuOption;
import controllers.UserController;

public class ShowUsersMenuOption implements MenuOption {
    private UserController userController;

    public ShowUsersMenuOption(UserController userController) {
        this.userController = userController;
    }

    @Override
    public void execute() {
        userController.showAllUsers();
    }

    @Override
    public String getDescription() {
        return "Show all users";
    }
}
