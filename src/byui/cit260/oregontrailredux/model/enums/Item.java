package byui.cit260.oregontrailredux.model.enums;


/**
 * @author Connor
 */
public enum Item {

    GOLD_DUST(0, 1000, 10),
    FOOD(1, 5, 1);

    /**
     * The index of a given item type in an Inventory's underlying array.
     * Explicitly declared here instead of relying on .ordinal(), which is
     * unsafe (according to Java documentation).
     */
    public final int index;

    /**
     * The monetary value of a given item type in USD.
     */
    public final int value;

    /**
     * The weight of a given item type in pounds.
     */
    public final int weight;

    Item(final int index, final int value, final int weight) {
        this.index = index;
        this.value = value;
        this.weight = weight;
    }
    
    public int getValue() {
        return this.value;
    }
}
