package byui.cit260.oregontrailredux.view;

/**
 * A data structure that represents a single item in any given Menu.
 * @author Connor
 */
public final class MenuItem {
    public final char symbol;
    public final String label;
    
    /**
     * A private default constructor prevents direct instantiation without
     * specifying a symbol and a label.
     */
    private MenuItem() {
        this.symbol = '\0';
        this.label  = "";
    }
    
    /**
     * A custom constructor assigns appropriate values to the MenuItem's
     * properties.
     * @param symbol
     * @param label
     */
    public MenuItem(char symbol, String label) {
        this.symbol = symbol;
        this.label  = label;
    }
}
