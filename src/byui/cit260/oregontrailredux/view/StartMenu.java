package byui.cit260.oregontrailredux.view;

import byui.cit260.oregontrailredux.view.print.TextBoxPrinter;
import byui.cit260.oregontrailredux.view.io.Input;
import byui.cit260.oregontrailredux.view.io.Output;
import byui.cit260.oregontrailredux.control.GameControl;
import byui.cit260.oregontrailredux.control.MapControl;
import byui.cit260.oregontrailredux.control.ViewControl;
import byui.cit260.oregontrailredux.view.print.MapPrinter;
import java.io.IOException;

/**
 * A menu used to start a new game or load a previous game.
 *
 * @author Connor
 */
public final class StartMenu extends AbstractMenu implements ViewInterface {

    /**
     * The default constructor.
     */
    public StartMenu() {
        this.title = "Oregon Trail Redux";
        this.addOption('N', "New game", () -> this.startNewGame());
        this.addOption('L', "Load game", () -> this.loadGame());
        this.addOption('A', "About", () -> this.displayAbout());
        this.addOption('H', "Help", () -> ViewControl.display("HelpMenu"));
        this.addOption('E', "Exit", () -> ViewControl.quitCurrentView());
    }

    /**
     * Displays information about the game.
     */
    private void displayAbout() {
        TextBoxPrinter.print("About this game");
    }

    /**
     * Loads a previously saved game.
     */
    private void loadGame() {
        GameControl.loadGame();
        Output.println("Welcome back, "
                + GameControl.getCurrentGame().getPlayer().getName()
                + "!");
        ViewControl.display("GameMenu");
    }

    /**
     * Starts a new game.
     */
    private void startNewGame() {
        try {
            String name = Input.getString("Enter your name:");
            GameControl.create(name);
            ViewControl.display("DifficultyMenu");
        } catch (IOException e) {
            // Log the exception?
        }
    }
}
