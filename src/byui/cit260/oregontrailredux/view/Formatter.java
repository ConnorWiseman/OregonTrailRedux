package byui.cit260.oregontrailredux.view;

import java.util.ArrayList;

/**
 * A class for formatting text boxes, menus, and so forth in a uniform style.
 * @author Connor
 */
public abstract class Formatter {
    private static final int  MAX_WIDTH = 64;
    private static final char H_SYMBOL  = '*';
    private static final char V_SYMBOL  = '*';
    
    /**
     * Creates a String padded to the specified length with a specified symbol.
     * @param length
     * @param symbol
     * @return
     */
    private static String padString(final int length, final char symbol) {
        String constructed = new String(new char[length]);
        return constructed.replace('\0', symbol);
    }
    
    /**
     * Prints a horizontal separator. Used to print the top and bottom borders
     * of text boxes, menus, and so forth. maxWidth is offset by 3 to account
     * for spacing within text boxes, menus, and so forth.
     * @param maxWidth
     * @param hSymbol
     */
    private static void printSeparator(final int maxWidth, final char hSymbol) {
        Output.println(Formatter.padString(maxWidth + 3, hSymbol));
    }
    
    /**
     * Prints a row of horizontal spacing. Used to print space within a formatted
     * text box, menu, and so forth.
     * @param maxWidth
     * @param vSymbol
     */
    private static void printSeparatorSpacing(final int maxWidth,
            final char vSymbol) {
        Output.println(vSymbol + Formatter.padString(maxWidth + 1, ' ') + vSymbol);
    }
    
    /**
     * Prints a line of text within a formatted text box, menu, and so forth.
     * @param line
     * @param maxWidth
     * @param vSymbol
     */
    private static void printLine(final String line, final int maxWidth, 
            final char vSymbol) {
        String paddedLine = vSymbol + " " + line;
        String emptySpace = Formatter.padString(maxWidth - line.length(), ' ');
        Output.println(paddedLine + emptySpace + vSymbol);
    }
    
    public static void displayMenu(final int maxWidth, final char hSymbol,
            final char vSymbol, final String title, final String ...lines) {
        Formatter.printSeparator(maxWidth, hSymbol);
        Formatter.printLine(title, maxWidth, vSymbol);
        Formatter.printSeparator(maxWidth, hSymbol);
        
        for (String line: lines) {
            Formatter.printLine(line, maxWidth, vSymbol);
        }

        Formatter.printSeparator(maxWidth, hSymbol);
    }
    
    public static void displayText(final String ...multiple) {
        // Display the top separator and spacing.
        Formatter.printSeparator(Formatter.MAX_WIDTH, Formatter.H_SYMBOL);
        Formatter.printSeparatorSpacing(Formatter.MAX_WIDTH, Formatter.V_SYMBOL);
        
        // Iterate over each String supplied as an argument.
        for (String text: multiple) {
            if (text.length() < MAX_WIDTH) {
                // If it's a short string, just display it as a line.
                Formatter.printLine(text, Formatter.MAX_WIDTH, Formatter.V_SYMBOL);
            }
            else {
                // If it's a long string, break it apart into words.
                String[] words = text.split(" ");
                
                // Prepare a temporary holder for preformatted lines.
                String tempLine = "";

                // Set up an ArrayList to hold our formatted lines.
                ArrayList<String> lines = new ArrayList<>();

                /* Iterate over each word and add it to the temporary line
                   until we hit the maximum width. */
                for (String word : words) {
                    if (tempLine.length() + word.length() < (Formatter.MAX_WIDTH)) {
                        tempLine += word + ' ';
                    }
                    else {
                        // Add the line to our ArrayList.
                        lines.add(tempLine);
                        // Do NOT forget to add the final word to the next line.
                        tempLine = word + ' ';
                    }
                }
                // Do NOT forget to add the final line to our ArrayList.
                lines.add(tempLine);
                
                // Display each line in the block of text.
                lines.stream().forEach((String line) -> {
                    Formatter.printLine(line, Formatter.MAX_WIDTH, Formatter.V_SYMBOL);
                });
            }
            // Display spacing after each block of text.
            Formatter.printSeparatorSpacing(Formatter.MAX_WIDTH, Formatter.V_SYMBOL);
        }
        // Display the bottom separator.
        Formatter.printSeparator(Formatter.MAX_WIDTH, Formatter.H_SYMBOL);
    }
}
