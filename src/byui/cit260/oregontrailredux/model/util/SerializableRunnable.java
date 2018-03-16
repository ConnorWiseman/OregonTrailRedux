package byui.cit260.oregontrailredux.model.util;

import java.io.Serializable;

/**
 * A functional interface that describes a lambda function that takes no
 * arguments and returns nothing. Extends Serializable. Used in the Command
 * class to implement the Command pattern.
 *
 * @author Connor
 * @private
 */
public interface SerializableRunnable extends Serializable {

    /**
     * Executes a lambda function.
     */
    public void run();
}
