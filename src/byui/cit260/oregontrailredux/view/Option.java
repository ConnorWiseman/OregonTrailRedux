package byui.cit260.oregontrailredux.view;

/**
 * A simple data structure representing a Menu option. Written to avoid a
 * pretty hacky Entry<String, Runnable> implementation in the Menu class.
 *
 * @author Connor
 * @private
 */
final class Option {

    /**
     * Every Menu option contains a label and a lambda function to be executed
     * when the Option is selected. An Option is immutable once instantiated.
     */
    public final String label;
    private final Runnable lambda;

    /**
     * Instantiates an Option.
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
    public void run() {
        this.lambda.execute();
    }
}
