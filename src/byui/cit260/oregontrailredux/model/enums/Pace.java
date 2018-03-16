package byui.cit260.oregontrailredux.model.enums;

/**
 * The acceptable paces for daily travel represented in miles. Probably subject
 * to change as programmer understanding of pioneer travel habits evolves.
 *
 * @author Connor
 */
public enum Pace {

    STOPPED('N', "Stopped", 0),
    SLOW('S', "Slow", 2),
    MODERATE('M', "Moderate", 5),
    GRUELING('G', "Grueling", 10);
    
    public final char symbol;
    
    public final String descriptor;

    /**
     * The value of a given pace in miles.
     */
    public final int value;

    Pace(final char symbol, final String descriptor, final int value) {
        this.symbol = symbol;
        this.descriptor = descriptor;
        this.value = value;
    }
}
