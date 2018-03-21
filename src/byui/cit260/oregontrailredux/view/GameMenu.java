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
        this.addOption('P', "Set pace", () -> ViewController.getInstance()
                .display(new SelectPaceMenu()));
        this.addOption('M', "Check map", ()
                -> MapPrinter.print(GameController.getCurrentGame().getMap()));
        this.addOption('S', "Save game", () -> this.saveGame());
        this.addOption('Q', "Quit", () -> {
            ViewController.getInstance().confirm("Do you really want to quit?",
                    () -> ViewController.getInstance().quitCurrentView(),
                    () -> ViewController.getInstance()
                            .changeTo(new GameMenu()));
        });
    }

    /**
     * Displays debug information.
     */
    private void displayDebugInfo() {
        Game currentGame = GameController.getCurrentGame();
        Output.println(currentGame.getPlayer());
        Output.println("Difficulty{mode=" + currentGame.getDifficulty() + "}");
        Output.println(currentGame.getTeam().getLeader());
        Output.println(currentGame.getTeam().getCompanions());
        Output.println(currentGame.getTeam().getOxen());
        Output.println(currentGame.getTeam().getWagon());
    }

    /**
     * Saves the current game.
     */
    private void saveGame() {
        GameController.getInstance().saveGame();
        Output.println("The game was saved successfully!");
    }
}
