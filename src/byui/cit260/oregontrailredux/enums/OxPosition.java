package byui.cit260.oregontrailredux.enums;

/**
 * @author Connor
 */
public enum OxPosition {
    LEFT(0),
    RIGHT(1);

    public final int position;
    
    OxPosition(final int position) {
        this.position = position;
    }
}