package menu.options;

import menu.MenuOption;
import controllers.UserController;
import java.util.Scanner;

public class AddUserMenuOption implements MenuOption {
    private UserController userController;

    public AddUserMenuOption(UserController userController) {
        this.userController = userController;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the user name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the user surname: ");
        String surname = scanner.nextLine();
        System.out.print("Enter the book title: ");
        String bookTitle = scanner.nextLine();
        userController.addUser(name, surname, bookTitle); 
    }

    @Override
    public String getDescription() {
        return "Add a new user";
    }
}
