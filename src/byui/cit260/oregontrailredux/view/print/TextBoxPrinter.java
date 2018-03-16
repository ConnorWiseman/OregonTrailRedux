package byui.cit260.oregontrailredux.view.print;

/**
 * Prints uniformly-formatted text boxes.
 *
 * @author Connor
 */
public final class TextBoxPrinter extends AbstractPrinter {

    private static final int MAX = 64;
    private static final char H = '*';
    private static final char V = '*';

    private TextBoxPrinter() {
    }

    private static void printParagraphs(final boolean spaced,
            final String... paragraphs) {
        AbstractPrinter.printBlankLine();
        AbstractPrinter.printSeparator(MAX, H);
        AbstractPrinter.printSeparatorSpacing(MAX, V);

        for (final String paragraph : paragraphs) {
            AbstractPrinter.printParagraph(paragraph, MAX, V, spaced);
        }

        if (!spaced) {
            AbstractPrinter.printSeparatorSpacing(MAX, V);
        }

        AbstractPrinter.printSeparator(MAX, H);
    }

    /**
     * Prints an arbitrary number of paragraphs as a formatted text box.
     *
     * @param paragraphs
     */
    public static void print(final String... paragraphs) {
        TextBoxPrinter.printParagraphs(true, paragraphs);
    }

    public static void printWithoutSpacing(final String... paragraphs) {
        TextBoxPrinter.printParagraphs(false, paragraphs);
    }
}
