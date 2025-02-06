package menu.options;

import menu.MenuOption;
import controllers.UserController;
import java.util.Scanner;

public class DeleteUserMenuOption implements MenuOption {
    private UserController userController;

    public DeleteUserMenuOption(UserController userController) {
        this.userController = userController;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the user name to delete: ");
        String name = scanner.nextLine();
        System.out.print("Enter the user surname: ");
        String surname = scanner.nextLine();
        userController.deleteUser(name, surname); 
    }

    @Override
    public String getDescription() {
        return "Delete a user";
    }
}
