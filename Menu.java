package menu;

import java.util.List;

public class Menu {
    private List<MenuOption> menuOptions;

    public Menu(List<MenuOption> menuOptions) {
        this.menuOptions = menuOptions;
    }

    public void display() {
        for (int i = 0; i < menuOptions.size(); i++) {
            System.out.println((i + 1) + ". " + menuOptions.get(i).getDescription());
        }
    }

    public void executeOption(int optionNumber) {
        if (optionNumber >= 1 && optionNumber <= menuOptions.size()) {
            menuOptions.get(optionNumber - 1).execute();
        } else {
            System.out.println("Invalid option. Please try again.");
        }
    }
}
