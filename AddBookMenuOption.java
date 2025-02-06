package menu.options;

import menu.MenuOption;
import controllers.BookController;
import java.util.Scanner;

public class AddBookMenuOption implements MenuOption {
    private BookController bookController;

    public AddBookMenuOption(BookController bookController) {
        this.bookController = bookController;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter the author: ");
        String author = scanner.nextLine();
        System.out.print("Enter the year: ");
        int year = scanner.nextInt();
        System.out.print("Enter the quantity: ");
        int quantity = scanner.nextInt();
        bookController.addNewBook(title, author, year, quantity); 
    }

    @Override
    public String getDescription() {
        return "Add a new book";
    }
}
