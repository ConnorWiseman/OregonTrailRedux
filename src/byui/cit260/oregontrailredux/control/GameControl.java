package byui.cit260.oregontrailredux.control;

import byui.cit260.oregontrailredux.model.Game;
import byui.cit260.oregontrailredux.model.Inventory;
import byui.cit260.oregontrailredux.model.Map;
import byui.cit260.oregontrailredux.model.Player;
import byui.cit260.oregontrailredux.model.Team;
import byui.cit260.oregontrailredux.model.Wagon;
import byui.cit260.oregontrailredux.view.ViewInterface;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Controls the Game class.
 * @author Connor
 */
public abstract class GameControl {
    private final static String SAVE_DIR = System.getProperty("user.home") +
        File.separator + "OregonTrailRedux";
    private final static String SAVE_PATH = GameControl.SAVE_DIR +
        File.separator + "save.data";

    private static Game currentGame;

    private static void makeSaveDirectory() {
        try {
            new File(GameControl.SAVE_DIR).mkdir();
        } catch (SecurityException e) {
            // Log the exception?
        }
    }

    /**
     * Creates a new instance of the Game class by creating instances of the
     * Player and Map classes and passing them to the Game class constructor.
     * @param playerName
     * @return 
     */
    public static Game create(final String playerName) {
        Game   game         = new Game();
        Player player       = PlayerControl.create(playerName);
        Map    map          = MapControl.create();
        Team   team         = TeamControl.create();
        Wagon  wagon        = WagonControl.create();
        Inventory inventory = InventoryControl.create();
        
        game.setPlayer(player);
        game.setMap(map);
        game.setTeam(team);
        team.setWagon(wagon);
        wagon.setCargo(inventory);
        
        GameControl.currentGame = game;
        return GameControl.currentGame;
    }
    
    /**
     * Returns the current currentGame.
     * @return
     */
    public static Game getCurrentGame() {
        return GameControl.currentGame;
    }
    
    /**
     * Loads an existing currentGame from a save file.
     */
    public static void loadExistingGame() {
        try (FileInputStream file = new FileInputStream(GameControl.SAVE_PATH)) {
            ObjectInputStream input = new ObjectInputStream(file);
            GameControl.currentGame = (Game) input.readObject();
            GameControl.startGame();
        } catch (Exception e) {
            
        }
    }
    
    /**
     * Saves the current currentGame to a save file.
     */
    public static void saveExistingGame() {
        GameControl.makeSaveDirectory();

        try (FileOutputStream fop = new FileOutputStream(GameControl.SAVE_PATH)) {
            ObjectOutputStream output = new ObjectOutputStream(fop);
            output.writeObject(GameControl.currentGame);
        } catch (IOException e) {
            
        }
    }

    /**
     * The main currentGame loop.
     */
    public static void startGame() {
        ViewControl.goToView("MenuStart");
        
        while (ViewControl.hasViews()) {
            ViewInterface currentView = ViewControl.getCurrentView();
            
            currentView.display();
            char choice = currentView.getInput();
            currentView.doAction(choice);
        }
    }
}
