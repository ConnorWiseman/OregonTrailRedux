package byui.cit260.oregontrailredux.model.enums;

/**
 * Definitions for the various Difficulty modes that users may select.
 *
 * @author Connor
 */
public enum Difficulty {
    EASY('E', "Easy", 2500),
    MODERATE('M', "Moderate", 2000),
    HARD('H', "Hard", 1500);

    public final char symbol;
    public final String descriptor;
    public final int initialMoney;

    Difficulty(final char symbol, final String descriptor,
            final int initialMoney) {
        this.symbol = symbol;
        this.descriptor = descriptor;
        this.initialMoney = initialMoney;
    }
}
