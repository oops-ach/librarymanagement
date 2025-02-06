package menu.options;

import menu.MenuOption;
import controllers.BookController;

public class ShowBooksMenuOption implements MenuOption {
    private BookController bookController;

    public ShowBooksMenuOption(BookController bookController) {
        this.bookController = bookController;
    }

    @Override
    public void execute() {
        bookController.showAllBooks(); 
    }

    @Override
    public String getDescription() {
        return "Show all books";
    }
}
