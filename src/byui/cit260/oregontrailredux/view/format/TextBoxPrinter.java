package byui.cit260.oregontrailredux.view.format;

/**
 * Prints uniformly-formatted text boxes.
 * @author Connor
 */
public abstract class TextBoxPrinter {

    private static final int MAX = 64;
    private static final char H = '*';
    private static final char V = '*';

    /**
     * Prints an arbitrary number of paragraphs as a formatted text box.
     * @param paragraphs
     */
    public static void print(final String... paragraphs) {
        Format.printBlankLine();
        Format.printSeparator(MAX, H);
        Format.printSeparatorSpacing(MAX, V);

        for (final String paragraph : paragraphs) {
            Format.printParagraph(paragraph, MAX, V);
        }

        Format.printSeparator(MAX, H);
    }
}
