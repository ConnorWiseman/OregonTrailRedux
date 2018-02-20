package byui.cit260.oregontrailredux.view;

// import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * Handles printing to whichever stream the class is configured to use. By
 * default, uses a PrintWriter wrapped around the System.out stream.
 * @author Connor
 */
public abstract class Output {
    // private final static PrintStream CONSOLE = System.out;
    private final static PrintWriter CONSOLE = new PrintWriter(System.out, true);

    /**
     * Prints text.
     * @param text
     */
    public static void print(String text) {
        Output.CONSOLE.print(text);
        Output.CONSOLE.flush();
    }
    
    /**
     * Prints text followed by a new line.
     * @param text
     */
    public static void println(String text) {
        Output.CONSOLE.println(text);
    }
    
    /**
     * Prints error text in red followed by a new line.
     * @param text
     */
    public static void error(String text) {
        Output.println("\u001B[31m" + text + "\u001B[31m");
    }
}
