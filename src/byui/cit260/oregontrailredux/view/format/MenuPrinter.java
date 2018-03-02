package byui.cit260.oregontrailredux.view.format;

/**
 * Prints uniformly-formatted text menus.
 * @author Connor
 */
public abstract class MenuPrinter {

    private static final int MAX = 32;
    private static final char H = '-';
    private static final char V = '|';

    /**
     * Prints a given Menu with a single title and an arbitrary number of
     * options as a formatted text menu.
     * @param title
     * @param options
     */
    public static void print(final String title, final String... options) {
        Format.printBlankLine();
        Format.printSeparator(MAX, H);
        Format.printLine(title, MAX, V);
        Format.printSeparator(MAX, H);

        for (String option : options) {
            Format.printLine(option, MAX, V);
        }

        Format.printSeparator(MAX, H);
    }
}
