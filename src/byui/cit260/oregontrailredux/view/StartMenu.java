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
        this.addOption('H', "Help", () -> ViewController.display(new HelpMenu()));
        this.addOption('E', "Exit", () -> ViewController.quitCurrentView());
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
        final GameController gc = new GameController();
        gc.loadGame();
        
        final String name = gc.getResource().getPlayer().getName();
        Output.println("Welcome back, " + name + "!");
        
        ViewController.display(new GameMenu());
    }

    /**
     * Starts a new game.
     */
    private void startNewGame() {
        try {
            final String name = Input.getString("Enter your name:");
            
            final Game currentGame = new GameController().getResource();
            
            final Player player = new PlayerController().getResource();
            player.setName(name);
            
            currentGame.setPlayer(player);
            currentGame.setMap(new MapController().create());
            currentGame.setTeam(new TeamController().create());
            
            ViewController.display(new DifficultyMenu());
        } catch (IOException e) {
            // Log the exception?
        }
    }
}
