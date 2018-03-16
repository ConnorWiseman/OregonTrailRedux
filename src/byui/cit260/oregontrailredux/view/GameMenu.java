package byui.cit260.oregontrailredux.view;

import byui.cit260.oregontrailredux.view.io.Output;
import byui.cit260.oregontrailredux.control.GameControl;
import byui.cit260.oregontrailredux.control.ViewControl;
import byui.cit260.oregontrailredux.view.print.MapPrinter;

/**
 * A menu used to play the current game.
 *
 * @author Connor
 */
public final class GameMenu extends AbstractMenu implements ViewInterface {

    /**
     * The default constructor.
     */
    public GameMenu() {
        this.title = "Play";
        this.addOption('D', "Debug info", () -> this.displayDebugInfo());
        this.addOption('P', "Set pace", () -> ViewControl.display("PaceMenu"));
        this.addOption('M', "Check map", () -> this.displayMap());
        this.addOption('S', "Save game", () -> this.saveGame());
        this.addOption('Q', "Quit", () -> {
            ViewControl.confirm("Do you really want to quit?",
                    () -> ViewControl.quitCurrentView(),
                    () -> ViewControl.changeTo("GameMenu"));
        });
    }

    /**
     * Displays debug information.
     */
    private void displayDebugInfo() {
        Output.println(GameControl.getCurrentGame().getPlayer().getName());
        Output.println(GameControl.getCurrentGame().getDifficulty());
        Output.println(GameControl.getCurrentGame().getTeam());
    }

    /**
     * Saves the current game.
     */
    private void saveGame() {
        GameControl.saveGame();
        Output.println("The game was saved successfully!");
    }

    private void displayMap() {
        MapPrinter.print(GameControl.getCurrentGame().getMap());
    }
}
