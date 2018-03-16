package byui.cit260.oregontrailredux.control;

import byui.cit260.oregontrailredux.control.util.Random;
import byui.cit260.oregontrailredux.model.Game;
import byui.cit260.oregontrailredux.model.Inventory;
import byui.cit260.oregontrailredux.model.Map;
import byui.cit260.oregontrailredux.model.Person;
import byui.cit260.oregontrailredux.model.Player;
import byui.cit260.oregontrailredux.model.Team;
import byui.cit260.oregontrailredux.model.Wagon;
import byui.cit260.oregontrailredux.model.enums.Difficulty;
import byui.cit260.oregontrailredux.view.ViewInterface;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Controls the Game class.
 *
 * @author Connor
 */
public final class GameControl {

    private final static String SAVE_DIR = System.getProperty("user.home")
            + File.separator + "OregonTrailRedux";
    private final static String SAVE_PATH = GameControl.SAVE_DIR
            + File.separator + "save.data";

    private static Game currentGame;

    private GameControl() {
    }

    /**
     * Makes the save directory.
     *
     * @todo Improve this!
     * @return
     */
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
     *
     * @param name
     * @return
     */
    public static Game create(final String name) {
        Game game = new Game();
        Player player = PlayerControl.create(name);
        Map map = MapControl.create();
        Team team = TeamControl.create();
        Wagon wagon = WagonControl.create();
        Inventory inventory = InventoryControl.create();

        game.setPlayer(player);
        game.setMap(map);
        game.setTeam(team);
        team.getLeader().setName(name);
        team.getLeader().setAge(Random.range(25, 35));
        team.setWagon(wagon);
        wagon.setCargo(inventory);

        GameControl.currentGame = game;
        return GameControl.currentGame;
    }

    /**
     * Returns the current currentGame.
     *
     * @return
     */
    public static Game getCurrentGame() {
        return GameControl.currentGame;
    }

    /**
     * Loads an existing currentGame from a save file.
     *
     * @todo Improve this!
     */
    public static void loadGame() {
        try (FileInputStream file = new FileInputStream(GameControl.SAVE_PATH)) {
            ObjectInputStream input = new ObjectInputStream(file);
            GameControl.currentGame = (Game) input.readObject();
        } catch (Exception e) {
            // Log the exception?
        }
    }

    /**
     * Saves the current currentGame to a save file.
     *
     * @todo Improve this!
     */
    public static void saveGame() {
        GameControl.makeSaveDirectory();

        try (FileOutputStream fop = new FileOutputStream(GameControl.SAVE_PATH)) {
            ObjectOutputStream output = new ObjectOutputStream(fop);
            output.writeObject(GameControl.currentGame);
        } catch (IOException e) {
            // Log the exception?
        }
    }

    /**
     * Sets the difficulty of the current Game. Intended to be called only once
     * at the start of the game.
     *
     * @param mode
     */
    public static void setDifficulty(final Difficulty mode) {
        GameControl.currentGame.setDifficulty(mode);
    }

    /**
     * The main Game loop. There is, and only ever should be, a single loop
     * powering all game logic. Nested loops are too complex to be readily
     * understood.
     */
    public static void startGame() {
        ViewControl.display("StartMenu");

        while (ViewControl.hasViews()) {
            ViewInterface currentView = ViewControl.getCurrentView();

            currentView.display();
            char choice = currentView.getInput();
            currentView.doAction(choice);
        }
    }
}
