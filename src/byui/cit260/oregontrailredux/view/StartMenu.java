package byui.cit260.oregontrailredux.view;

import byui.cit260.oregontrailredux.view.format.TextBoxPrinter;
import byui.cit260.oregontrailredux.view.io.Input;
import byui.cit260.oregontrailredux.view.io.Output;
import byui.cit260.oregontrailredux.control.GameControl;
import byui.cit260.oregontrailredux.control.ViewControl;
import java.io.IOException;

public final class StartMenu extends Menu implements ViewInterface {

    public StartMenu() {
        this.title = "Oregon Trail Redux";
        this.addOption('N', "New game", () -> this.startNewGame());
        this.addOption('L', "Load game", () -> this.loadGame());
        this.addOption('A', "About", () -> this.displayAbout());
        this.addOption('H', "Help", () -> ViewControl.goToView("HelpMenu"));
        this.addOption('E', "Exit", () -> ViewControl.quitCurrentView());
    }

    private void displayAbout() {
        TextBoxPrinter.print("About this game");
    }

    private void loadGame() {
        GameControl.loadGame();
        Output.println("Welcome back, "
                + GameControl.getCurrentGame().getPlayer().getName()
                + "!");
        ViewControl.goToView("GameMenu");
    }

    private void startNewGame() {
        try {
            String name = Input.getString("Enter your name:");
            GameControl.create(name);
            ViewControl.goToView("DifficultyMenu");
        } catch (IOException e) {
            // Log the exception?
        }
    }
}
