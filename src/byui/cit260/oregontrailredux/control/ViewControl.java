package byui.cit260.oregontrailredux.control;

import java.util.ArrayList;

import byui.cit260.oregontrailredux.view.Output;
import byui.cit260.oregontrailredux.view.ViewInterface;

/**
 * Controls which View the game is currently displaying.
 * @author Connor
 */
public abstract class ViewControl {
    private static final ArrayList<ViewInterface> VIEWS = new ArrayList<>();
    
    /**
     * Returns true if the underlying ArrayList of views has anything in it.
     * @return
     */
    public static boolean hasViews() {
        return ViewControl.VIEWS.size() > 0;
    }
    
    /**
     * Returns the last ViewInterface in the underlying ArrayList.
     * @return
     */
    public static ViewInterface getCurrentView() {
        return ViewControl.VIEWS.get(ViewControl.VIEWS.size() - 1);
    }
    
    /**
     * Uses reflection to create and append another ViewInterface to the
     * underlying ArrayList.
     * @param target
     */
    public static void goToView(final String target) {
        try {
            Class c = Class.forName("byui.cit260.oregontrailredux.view." +
                    target);
            ViewInterface view = (ViewInterface) c.newInstance();
            
            ViewControl.VIEWS.add(view);
        } catch (ClassNotFoundException | IllegalAccessException |
                InstantiationException e) {
            Output.printError(e.toString());
        }
    }
    
    /**
     * Removes the last ViewInterface from the underlying ArrayList.
     */
    public static void quitCurrentView() {
        ViewControl.VIEWS.remove(ViewControl.VIEWS.size() - 1);
    }
}
