package byui.cit260.oregontrailredux.view;

import byui.cit260.oregontrailredux.view.util.Runnable;

/**
 * A simple data structure representing a menu option. Written to avoid a pretty
 * hacky Entry<String, Runnable> implementation in the Menu class.
 *
 * @author Connor
 * @private
 */
final class Option {

    /**
     * The Option label.
     */
    public final String label;

    /**
     * The function executed when the Option is selected.
     */
    private final Runnable lambda;

    /**
     * Instantiates an Option. Every Option contains a label and a lambda
     * function to be executed when the Option is selected. An Option is
     * immutable once instantiated.
     *
     * @param label
     * @param lambda
     */
    public Option(final String label, final Runnable lambda) {
        this.label = label;
        this.lambda = lambda;
    }

    /**
     * Executes the Option's lambda function.
     */
    public void select() {
        this.lambda.run();
    }
}
