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

    private static final ArrayList<ViewInterface> VIEWS = new ArrayList<>();

    private ViewController() {
    }
    
    /**
     * Quits the current view, then transitions to the specified ViewInterface.
     *
     * @param view
     */
    public static void changeTo(final ViewInterface view) {
        ViewController.quitCurrentView();
        ViewController.display(view);
    }

    /**
     * Quits the current ViewInterface, then displays a ConfirmMenu to confirm
     * some sensitive action.
     *
     * @param prompt
     * @param y
     * @param n
     */
    public static void confirm(final String prompt, final Runnable y,
            final Runnable n) {
        ViewController.changeTo(new ConfirmMenu(prompt, y, n));
    }

    /**
     * Displays the specified ViewInterface.
     *
     * @param view
     */
    public static void display(final ViewInterface view) {
        ViewController.VIEWS.add(view);
    }

    /**
     * Returns true if the underlying ArrayList of views has anything in it.
     *
     * @return
     */
    public static boolean hasViews() {
        return ViewController.VIEWS.size() > 0;
    }

    /**
     * Returns the last ViewInterface in the underlying ArrayList.
     *
     * @return
     */
    public static ViewInterface getCurrentView() {
        return ViewController.VIEWS.get(ViewController.VIEWS.size() - 1);
    }

    /**
     * Removes the last ViewInterface from the underlying ArrayList.
     */
    public static void quitCurrentView() {
        ViewController.VIEWS.remove(ViewController.VIEWS.size() - 1);
    }
}
