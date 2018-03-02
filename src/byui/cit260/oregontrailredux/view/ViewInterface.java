package byui.cit260.oregontrailredux.view;

/**
 * The basic interface implemented by every view. Used primarily by the Menu
 * class and its subclasses.
 *
 * @author Connor
 */
public interface ViewInterface {

    /**
     * Acquires input for the current view.
     *
     * @return
     */
    public char getInput();

    /**
     * Performs the chosen action with the current view. Returns true if the
     * view is completed and false if the view is still in progress.
     *
     * @param choice
     */
    public void doAction(final char choice);

    /**
     * Displays the current view.
     */
    public void display();
}
