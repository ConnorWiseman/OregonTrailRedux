package byui.cit260.oregontrailredux.model.enums;

/**
 * Definitions for the various Professions that users may select.
 *
 * @author Connor
 */
public enum Profession {

    NONE('N', "Unspecified", 0),
    FARMER('F', "Farmer", 400),
    CARPENTER('C', "Carpenter", 500),
    HUNTER('H', "Hunter", 600),
    BANKER('B', "Banker", 800),
    PROPHET('P', "Prophet", 10000);

    /**
     * The symbol associated with a given Profession inside a menu Option.
     */
    public final char symbol;

    /**
     * The string describing a given Profession inside a menu Option.
     */
    public final String descriptor;

    /**
     * The amount of money to be distributed to a Team when a new game is
     * started.
     */
    public final int initialMoney;

    Profession(final char symbol, final String descriptor,
            final int initialMoney) {
        this.symbol = symbol;
        this.descriptor = descriptor;
        this.initialMoney = initialMoney;
    }
}
