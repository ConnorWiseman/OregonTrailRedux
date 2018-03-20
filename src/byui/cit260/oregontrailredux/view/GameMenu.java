package byui.cit260.oregontrailredux.view;

import byui.cit260.oregontrailredux.view.io.Output;
import byui.cit260.oregontrailredux.control.GameController;
import byui.cit260.oregontrailredux.control.ViewController;
import byui.cit260.oregontrailredux.model.Game;
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
        this.addOption('P', "Set pace", () -> ViewController.display(new PaceMenu()));
        this.addOption('M', "Check map", () -> this.displayMap());
        this.addOption('S', "Save game", () -> this.saveGame());
        this.addOption('Q', "Quit", () -> {
            ViewController.confirm("Do you really want to quit?",
                    () -> ViewController.quitCurrentView(),
                    () -> ViewController.changeTo(new GameMenu()));
        });
    }

    /**
     * Displays debug information.
     */
    private void displayDebugInfo() {
        Game currentGame = new GameController().getResource();
        Output.println(currentGame.getPlayer());
        Output.println("Difficulty{mode=" + currentGame.getDifficulty() + "}");
        Output.println(currentGame.getTeam().getLeader());
        Output.println(currentGame.getTeam().getCompanions());
        Output.println(currentGame.getTeam().getOxen());
        Output.println(currentGame.getTeam().getWagon());
    }
    
    /**
     * Displays the map.
     */
    private void displayMap() {
        MapPrinter.print(new GameController().getResource().getMap());
    }

    /**
     * Saves the current game.
     */
    private void saveGame() {
        new GameController().saveGame();
        Output.println("The game was saved successfully!");
    }
}
