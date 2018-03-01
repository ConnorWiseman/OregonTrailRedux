package byui.cit260.oregontrailredux.enums;

/**
 * @author Connor
 */
public enum Item {
    GOLD_DUST(0, 1000, 10),
    FOOD(1, 5, 1);

    public final int index;
    public final int value;
    public final int weight;
    
    Item(final int index, final int value, final int weight) {
        this.index  = index;
        this.value  = value;
        this.weight = weight;
    }
}