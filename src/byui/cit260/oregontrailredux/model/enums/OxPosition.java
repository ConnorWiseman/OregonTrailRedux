package byui.cit260.oregontrailredux.model.enums;

/**
 * An enum of potential Ox positions in a given pair of Oxen.
 * 
 * @author Connor
 */
public enum OxPosition {

    LEFT(0),
    RIGHT(1);

    /**
     * The position of an Ox, given as an array index.
     */
    public final int position;

    OxPosition(final int position) {
        this.position = position;
    }
}
