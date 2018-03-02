package byui.cit260.oregontrailredux.model.enums;

/**
 * The acceptable paces for daily travel represented in miles. Probably subject
 * to change as programmer understanding of pioneer travel habits evolves.
 *
 * @author Connor
 */
public enum Pace {
    STOPPED(0),
    SLOW(2),
    MODERATE(5),
    GRUELING(10);

    public final int value;

    Pace(final int value) {
        this.value = value;
    }
}
