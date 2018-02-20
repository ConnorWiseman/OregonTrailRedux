package byui.cit260.oregontrailredux.view;

import byui.cit260.oregontrailredux.model.Game;

/**
 * The basic interface implemented by every view.
 * @author Connor
 */
public interface ViewInterface {

    /**
     * Acquires input for the current view.
     */
    public char getInput();

    /**
     * Performs the chosen action with the current view. Returns true if the
     * view is completed and false if the view is still in progress. Requires
     * an instance of the Game class; see GameControl.startGame
     */
    public void doAction(char choice, Game game);

    /**
     * Displays the current view.
     */
    public void display();
}
