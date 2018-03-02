package byui.cit260.oregontrailredux.view.io;

import java.io.PrintWriter;

/**
 * Handles printing to whichever stream the class is configured to use. By
 * default, uses a PrintWriter wrapped around the System.out stream.
 *
 * @author Connor
 */
public abstract class Output {

    private final static PrintWriter OUT = new PrintWriter(System.out, true);

    /**
     * Prints text.
     *
     * @param <T>
     * @param text
     */
    public static <T> void print(final T text) {
        Output.OUT.print(text);
        Output.OUT.flush();
    }

    /**
     * Prints text followed by a new line.
     *
     * @param <T>
     * @param text
     */
    public static <T> void println(final T text) {
        Output.OUT.println(text);
    }

    /**
     * Prints error text in red followed by a new line.
     *
     * @param <T>
     * @param text
     */
    public static <T> void printError(final T text) {
        Output.println("\u001B[31m" + text + "\u001B[31m");
    }
}
