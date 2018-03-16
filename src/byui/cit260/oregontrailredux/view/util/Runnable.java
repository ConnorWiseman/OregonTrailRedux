package byui.cit260.oregontrailredux.view.util;

/**
 * A functional interface that describes a lambda function that takes no
 * arguments and returns nothing. Used in the Menu class and its subclasses.
 * Also implemented by the Option class for kicks and giggles.
 *
 * @author Connor
 * @private
 */
public interface Runnable {

    /**
     * Executes a lambda function.
     */
    public void run();
}
