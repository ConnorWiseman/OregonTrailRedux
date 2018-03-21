package byui.cit260.oregontrailredux.control;

import byui.cit260.oregontrailredux.model.Game;
import byui.cit260.oregontrailredux.model.Map;
import byui.cit260.oregontrailredux.model.Player;
import byui.cit260.oregontrailredux.view.StartMenu;
import byui.cit260.oregontrailredux.view.ViewInterface;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Controls the Game class. Implemented as a Singleton object.
 *
 * @author Connor
 */
public final class GameController {

    private final static GameController INSTANCE = new GameController();
    private final static String SAVE_DIR = System.getProperty("user.home")
            + File.separator + "OregonTrailRedux";
    private final static String SAVE_PATH = GameController.SAVE_DIR
            + File.separator + "save.data";

    private final static Game CURRENT_GAME = new Game();

    private GameController() {}

    /**
     * Makes the save directory.
     *
     * @todo Improve this!
     * @return
     */
    private void makeSaveDirectory() {
        try {
            new File(GameController.SAVE_DIR).mkdir();
        } catch (SecurityException e) {
            // Log the exception?
        }
    }
    
    public static Game getCurrentGame() {
        return GameController.CURRENT_GAME;
    }
    
    public static GameController getInstance() {
        return GameController.INSTANCE;
    }

    /**
     * Creates a new instance of the Game class by creating instances of the
     * Player and Map classes and passing them to the Game class constructor.
     *
     * @param player
     * @param map
     * @return
     */
    public Game initialize(final Player player, final Map map) {

        //Inventory inventory = InventoryController.create();

        GameController.CURRENT_GAME.setPlayer(player);
        GameController.CURRENT_GAME.setMap(map);
        //this.currentGame.setTeam(team);
        //team.getLeader().setName(player.getName());
        //team.getLeader().setAge(Random.range(25, 35));
        //team.setWagon(wagon);
        //wagon.setCargo(inventory);

        return GameController.CURRENT_GAME;
    }
 
    /**
     * Loads an existing currentGame from a save file.
     *
     * @todo Improve this!
     */
    public void loadGame() {
        try (FileInputStream file = new FileInputStream(GameController.SAVE_PATH)) {
            ObjectInputStream input = new ObjectInputStream(file);
            Game loaded = (Game) input.readObject();
            
            GameController.CURRENT_GAME.setDifficulty(loaded.getDifficulty());
            GameController.CURRENT_GAME.setMap(loaded.getMap());
            GameController.CURRENT_GAME.setPlayer(loaded.getPlayer());
            GameController.CURRENT_GAME.setRunning(loaded.isRunning());
            GameController.CURRENT_GAME.setTeam(loaded.getTeam());
        } catch (Exception e) {
            // Log the exception?
        }
    }

    /**
     * Saves the current currentGame to a save file.
     *
     * @todo Improve this!
     */
    public void saveGame() {
        this.makeSaveDirectory();

        try (FileOutputStream fop = new FileOutputStream(GameController.SAVE_PATH)) {
            ObjectOutputStream output = new ObjectOutputStream(fop);
            output.writeObject(GameController.CURRENT_GAME);
        } catch (IOException e) {
            // Log the exception?
        }
    }

    /**
     * The main Game loop. There is, and only ever should be, a single loop
     * powering all game logic. Nested loops are too complex to be readily
     * understood.
     */
    public void startGame() {
        ViewController vc = ViewController.getInstance();
        vc.display(new StartMenu());

        while (vc.hasViews()) {
            ViewInterface currentView = vc.getCurrentView();

            currentView.display();
            char choice = currentView.getInput();
            currentView.doAction(choice);
        }
    }
}
