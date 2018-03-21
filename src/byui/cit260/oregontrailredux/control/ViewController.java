package byui.cit260.oregontrailredux.control;

import byui.cit260.oregontrailredux.view.ConfirmMenu;
import byui.cit260.oregontrailredux.view.ViewInterface;
import byui.cit260.oregontrailredux.view.util.Runnable;
import java.util.ArrayList;

/**
 * Controls which view the game is currently displaying.
 *
 * @author Connor
 */
public final class ViewController {

    private static final ViewController INSTANCE = new ViewController();
    
    private final ArrayList<ViewInterface> VIEWS = new ArrayList<>();

    private ViewController() {}
    
    public static ViewController getInstance() {
        return ViewController.INSTANCE;
    }
    
    /**
     * Quits the current view, then transitions to the specified ViewInterface.
     *
     * @param view
     */
    public void changeTo(final ViewInterface view) {
        this.quitCurrentView();
        this.display(view);
    }

    /**
     * Quits the current ViewInterface, then displays a ConfirmMenu to confirm
     * some sensitive action.
     *
     * @param prompt
     * @param y
     * @param n
     */
    public void confirm(final String prompt, final Runnable y,
            final Runnable n) {
        this.changeTo(new ConfirmMenu(prompt, y, n));
    }

    /**
     * Displays the specified ViewInterface.
     *
     * @param view
     */
    public void display(final ViewInterface view) {
        this.VIEWS.add(view);
    }

    /**
     * Returns true if the underlying ArrayList of views has anything in it.
     *
     * @return
     */
    public boolean hasViews() {
        return this.VIEWS.size() > 0;
    }

    /**
     * Returns the last ViewInterface in the underlying ArrayList.
     *
     * @return
     */
    public ViewInterface getCurrentView() {
        return this.VIEWS.get(this.VIEWS.size() - 1);
    }

    /**
     * Removes the last ViewInterface from the underlying ArrayList.
     */
    public void quitCurrentView() {
        this.VIEWS.remove(this.VIEWS.size() - 1);
    }
}
