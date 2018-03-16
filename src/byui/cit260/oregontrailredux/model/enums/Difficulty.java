package byui.cit260.oregontrailredux.model.enums;

/**
 * Definitions for the various Difficulty modes that users may select.
 *
 * @author Connor
 */
public enum Difficulty {

    EASY('E', "Easy", 1.5),
    MODERATE('M', "Moderate", 1.2),
    HARD('H', "Hard", 1.0);

    /**
     * The symbol associated with a given Difficulty mode inside any Menu's
     * Option.
     */
    public final char symbol;

    /**
     * The string describing a given Difficulty mode inside any Menu's Option.
     */
    public final String descriptor;

    /**
     * The Difficulty modifier. Affects initial money, upper and lower bounds
     * for Companions, and other such things.
     */
    public final double modifier;

    Difficulty(final char symbol, final String descriptor,
            final double initialMoneyModifier) {
        this.symbol = symbol;
        this.descriptor = descriptor;
        this.modifier = initialMoneyModifier;
    }
}
