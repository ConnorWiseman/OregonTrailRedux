package byui.cit260.oregontrailredux.control;

import byui.cit260.oregontrailredux.view.ConfirmMenu;
import java.util.ArrayList;

import byui.cit260.oregontrailredux.view.ViewInterface;
import byui.cit260.oregontrailredux.view.util.Runnable;

/**
 * Controls which view the game is currently displaying.
 *
 * @author Connor
 */
public final class ViewControl {

    private static final ArrayList<ViewInterface> VIEWS = new ArrayList<>();

    private ViewControl() {
    }

    /**
     * Quits the current view, then transitions to the target view.
     *
     * @param target
     */
    public static void changeTo(final String target) {
        ViewControl.quitCurrentView();
        ViewControl.display(target);
    }

    /**
     * Quits the current view, then transitions to the specified ViewInterface.
     *
     * @param view
     */
    public static void changeTo(final ViewInterface view) {
        ViewControl.quitCurrentView();
        ViewControl.display(view);
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
        ViewControl.changeTo(new ConfirmMenu(prompt, y, n));
    }

    /**
     * Uses reflection to create and append another ViewInterface to the
     * underlying ArrayList.
     *
     * @param target
     */
    public static void display(final String target) {
        try {
            Class c = Class.forName("byui.cit260.oregontrailredux.view."
                    + target);
            ViewInterface view = (ViewInterface) c.newInstance();

            ViewControl.display(view);
        } catch (ClassNotFoundException | IllegalAccessException
                | InstantiationException e) {
            // Log the exception?
        }
    }

    /**
     * Displays the specified ViewInterface.
     *
     * @param view
     */
    public static void display(final ViewInterface view) {
        ViewControl.VIEWS.add(view);
    }

    /**
     * Returns true if the underlying ArrayList of views has anything in it.
     *
     * @return
     */
    public static boolean hasViews() {
        return ViewControl.VIEWS.size() > 0;
    }

    /**
     * Returns the last ViewInterface in the underlying ArrayList.
     *
     * @return
     */
    public static ViewInterface getCurrentView() {
        return ViewControl.VIEWS.get(ViewControl.VIEWS.size() - 1);
    }

    /**
     * Removes the last ViewInterface from the underlying ArrayList.
     */
    public static void quitCurrentView() {
        ViewControl.VIEWS.remove(ViewControl.VIEWS.size() - 1);
    }
}
