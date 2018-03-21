package byui.cit260.oregontrailredux.view;

import byui.cit260.oregontrailredux.control.GameController;
import byui.cit260.oregontrailredux.control.MapController;
import byui.cit260.oregontrailredux.control.PlayerController;
import byui.cit260.oregontrailredux.control.TeamController;
import byui.cit260.oregontrailredux.control.ViewController;
import byui.cit260.oregontrailredux.model.Game;
import byui.cit260.oregontrailredux.model.Player;
import byui.cit260.oregontrailredux.view.io.Input;
import byui.cit260.oregontrailredux.view.io.Output;
import byui.cit260.oregontrailredux.view.print.TextBoxPrinter;
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
        this.addOption('H', "Help", ()
                -> ViewController.getInstance().display(new HelpMenu()));
        this.addOption('E', "Exit", ()
                -> ViewController.getInstance().quitCurrentView());
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
        GameController.getInstance().loadGame();
        
        final String name = GameController.getCurrentGame().getPlayer()
                .getName();
        Output.println("Welcome back, " + name + "!");
        
        ViewController.getInstance().display(new GameMenu());
    }

    /**
     * Starts a new game.
     */
    private void startNewGame() {
        try {
            final String name = Input.getString("Enter your name:");
            
            final Game currentGame = GameController.getCurrentGame();
            
            final Player player = PlayerController.create();
            player.setName(name);
            
            currentGame.setPlayer(player);
            currentGame.setMap(MapController.create());
            currentGame.setTeam(TeamController.create());
            
            ViewController.getInstance().display(new SelectDifficultyMenu());
        } catch (IOException e) {
            // Log the exception?
        }
    }
}
