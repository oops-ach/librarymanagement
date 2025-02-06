package menu.options;

import menu.MenuOption;
import controllers.BookController;
import java.util.Scanner;

public class ReturnBookMenuOption implements MenuOption {
    private BookController bookController;

    public ReturnBookMenuOption(BookController bookController) {
        this.bookController = bookController;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.next();
        System.out.println("Enter your surname: ");
        String surname = scanner.next();
        System.out.print("Enter the book title to return: ");
        String title = scanner.nextLine();
        bookController.returnBook(name, surname, title);
    }

    @Override
    public String getDescription() {
        return "Return a book";
    }
}
