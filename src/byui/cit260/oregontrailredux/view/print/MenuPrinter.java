package byui.cit260.oregontrailredux.view.print;

/**
 * Prints uniformly-formatted text menus.
 *
 * @author Connor
 */
public final class MenuPrinter extends AbstractPrinter {

    private static final int MAX = 32;
    private static final char H = '-';
    private static final char V = '|';

    private MenuPrinter() {
    }

    /**
     * Prints a given Menu with a single title and an arbitrary number of
     * options as a formatted text menu.
     *
     * @param title
     * @param options
     */
    public static void print(final String title, final String... options) {
        AbstractPrinter.printBlankLine();
        AbstractPrinter.printSeparator(MAX, H);
        AbstractPrinter.printLine(title, MAX, V);
        AbstractPrinter.printSeparator(MAX, H);

        for (final String option : options) {
            AbstractPrinter.printLine(option, MAX, V);
        }

        AbstractPrinter.printSeparator(MAX, H);
    }
}
