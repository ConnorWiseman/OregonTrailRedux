package byui.cit260.oregontrailredux.model;

import byui.cit260.oregontrailredux.model.enums.Item;
import byui.cit260.oregontrailredux.view.io.Output;
import java.io.Serializable;
import java.util.Arrays;

/**
 * A wrapper class around an array of integers representing item quantities. The
 * remainder of information about each item is stored in the Item enum.
 *
 * @author Connor
 */
public final class Inventory implements Serializable {

    private int[] quantities;

    /**
     * Default constructor.
     */
    public Inventory() {
        this.quantities = new int[]{};
    }

    /**
     * Gets the quantity of a specific type of Item.
     *
     * @param type
     * @return
     */
    public int getQuantity(final Item type) {
        return this.quantities[type.index];
    }

    /**
     * Sets the quantity of a specific type of Item.
     *
     * @param type
     * @param quantity
     */
    public void setQuantity(final Item type, final int quantity) {
        this.quantities[type.index] = quantity;
    }

    /**
     * Returns the entire array of integers. Usage is not advised.
     *
     * @return
     */
    public int[] getQuantities() {
        return quantities;
    }

    /**
     * Sets the entire array of integers. Usage is not advised.
     *
     * @param quantities
     */
    public void setQuantities(final int[] quantities) {
        this.quantities = quantities;
    }
    
    public int getValue(final Item type) {
        return type.value;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Arrays.hashCode(this.quantities);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Inventory other = (Inventory) obj;
        return Arrays.equals(this.quantities, other.quantities);
    }

    @Override
    public String toString() {
        return "Inventory{" + "contents=" + Arrays.toString(quantities) + '}';
    }
}
