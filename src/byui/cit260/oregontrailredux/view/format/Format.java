package byui.cit260.oregontrailredux.view.format;

import byui.cit260.oregontrailredux.view.io.Output;
import java.util.ArrayList;

/**
 * A class for formatting text boxes, menus, and so forth in a uniform style.
 *
 * @author Connor
 * @private
 */
abstract class Format {

    /**
     * Creates a String padded to the specified length with a specified symbol.
     *
     * @param length
     * @param symbol
     * @return
     */
    protected static String padString(final int length, final char symbol) {
        String constructed = new String(new char[length]);
        return constructed.replace('\0', symbol);
    }

    /**
     * Prints a blank line.
     */
    protected static void printBlankLine() {
        Output.println("");
    }

    /**
     * Prints a line of text within a formatted text box, menu, and so forth.
     *
     * @param line
     * @param maxWidth
     * @param vSymbol
     */
    protected static void printLine(final String line, final int maxWidth,
            final char vSymbol) {
        String paddedLine = vSymbol + " " + line;
        String emptySpace = Format.padString(maxWidth - line.length(), ' ');
        Output.println(paddedLine + emptySpace + vSymbol);
    }

    /**
     * Prints a paragraph of text within a formatted text box.
     *
     * @param paragraph
     * @param maxWidth
     * @param vSymbol
     */
    protected static void printParagraph(final String paragraph,
            final int maxWidth, final char vSymbol) {
        ArrayList<String> lines = new ArrayList<>();

        if (paragraph.length() < maxWidth) {
            lines.add(paragraph);
        } else {
            String line = "";

            for (final String word : paragraph.split(" ")) {
                if (line.length() + word.length() < maxWidth) {
                    line += word + ' ';
                } else {
                    lines.add(line);
                    line = word + ' ';
                }
            }

            lines.add(line);
        }

        lines.forEach((line)
                -> Format.printLine(line, maxWidth, vSymbol));
        Format.printSeparatorSpacing(maxWidth, vSymbol);
    }

    /**
     * Prints a horizontal separator. Used to print the top and bottom borders
     * of text boxes, menus, and so forth. maxWidth is offset by 3 to account
     * for spacing within text boxes, menus, and so forth.
     *
     * @param maxWidth
     * @param hSymbol
     */
    protected static void printSeparator(final int maxWidth,
            final char hSymbol) {
        Output.println(Format.padString(maxWidth + 3, hSymbol));
    }

    /**
     * Prints a row of horizontal spacing. Used to print space within a
     * formatted text box, menu, and so forth.
     *
     * @param maxWidth
     * @param vSymbol
     */
    protected static void printSeparatorSpacing(final int maxWidth,
            final char vSymbol) {
        Output.println(vSymbol
                + Format.padString(maxWidth + 1, ' ') + vSymbol);
    }
}
