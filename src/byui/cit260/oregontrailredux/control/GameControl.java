package byui.cit260.oregontrailredux.control;

import byui.cit260.oregontrailredux.model.Game;
import byui.cit260.oregontrailredux.model.Map;
import byui.cit260.oregontrailredux.model.Player;

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

    private static void makeSaveDirectory() {
        try {
            new File(GameControl.SAVE_DIR).mkdir();
        } catch (SecurityException e) {
            
        }
    }

    /**
     * Creates a new instance of the Game class by creating instances of the
     * Player and Map classes and passing them to the Game class constructor.
     * @param playerName
     * @return 
     */
    public static Game createNewGame(String playerName) {
        Player player = PlayerControl.createNewPlayer(playerName);
        Map    map    = MapControl.createNewMap();
        
        return new Game(player, map);
    }
    
    public static void loadExistingGame() {
        try (FileInputStream file = new FileInputStream(GameControl.SAVE_PATH)) {
            ObjectInputStream input = new ObjectInputStream(file);
            Game game = (Game) input.readObject();
            GameControl.startGame(game);
        } catch (Exception e) {
            
        }
    }
    
    public static void saveExistingGame(Game game) {
        GameControl.makeSaveDirectory();

        try (FileOutputStream fop = new FileOutputStream(GameControl.SAVE_PATH)) {
            ObjectOutputStream output = new ObjectOutputStream(fop);
            output.writeObject(game);
        } catch (IOException e) {
            
        }
    }
    
    /**
     * The main game loop: creates a ViewStack, pushes a GameMenu onto it, and
     * loops as long as the ViewStack contains views. Passes the local Game
     * instance into each view's doAction method so the view can appropriately
     * delegate to other Controller methods as needed.
     * @param game
     */
    public static void startGame(Game game) {
        ViewControl.goToView("GameMenu");
        
        while (ViewControl.hasViews()) {
            ViewInterface currentView = ViewControl.getCurrentView();
            
            currentView.display();
            char choice = currentView.getInput();
            currentView.doAction(choice, game);
        }
    }
}
