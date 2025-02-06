package menu.options;

import menu.MenuOption;
import controllers.BookController;
import java.util.Scanner;

public class DeleteBookMenuOption implements MenuOption {
    private BookController bookController;

    public DeleteBookMenuOption(BookController bookController) {
        this.bookController = bookController;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the book title to delete: ");
        String title = scanner.nextLine();
        bookController.deleteBook(title); 
    }

    @Override
    public String getDescription() {
        return "Delete a book";
    }
}
