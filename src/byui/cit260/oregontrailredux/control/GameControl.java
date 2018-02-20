package byui.cit260.oregontrailredux.control;

import byui.cit260.oregontrailredux.model.Game;
import byui.cit260.oregontrailredux.model.Map;
import byui.cit260.oregontrailredux.model.Player;

import byui.cit260.oregontrailredux.view.ViewInterface;
import byui.cit260.oregontrailredux.view.ViewStack;
import byui.cit260.oregontrailredux.view.MainMenu;

/**
 * Controls the Game class.
 * @author Connor
 */
public abstract class GameControl {

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
    
    /**
     * The main game loop: creates a ViewStack, pushes a MainMenu onto it, and
     * loops as long as the ViewStack contains views. Passes the local Game
     * instance into each view's doAction method so the view can appropriately
     * delegate to other Controller methods as needed.
     * @param game
     */
    public static void startGame(Game game) {
        ViewStack views = new ViewStack();
        views.push(new MainMenu(views));
        
        while (views.size() > 0) {
            ViewInterface currentView = views.top();
            
            currentView.display();
            char choice = currentView.getInput();
            currentView.doAction(choice, game);
        }
    }
}
