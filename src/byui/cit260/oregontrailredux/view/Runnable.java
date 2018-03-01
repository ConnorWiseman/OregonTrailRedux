package byui.cit260.oregontrailredux.view;

/**
 * A functional interface that describes a lambda function that takes no
 * arguments and returns nothing. Used in the Menu class to keep track of
 * callback functions for Menu entries.
 * @author Connor
 */
public interface Runnable {

    /**
     * Executes the lambda function.
     */
    public void execute();
}
