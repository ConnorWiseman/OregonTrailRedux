package byui.cit260.oregontrailredux.control;

import byui.cit260.oregontrailredux.model.enums.Item;
import byui.cit260.oregontrailredux.model.Inventory;
import java.util.function.Function;

/**
 * Controls the Inventory class.
 *
 * @author Connor
 */
public final class InventoryController implements ControllerInterface {

    private final Inventory inventory;

    public InventoryController() {
        this.inventory = new Inventory();
    }

    public InventoryController(final Inventory inventory) {
        this.inventory = inventory;
    }

    /**
     * Adds the specified quantity of the specified type of item to the
     * specified inventory.
     *
     * @param quantity
     * @param type
     */
    public void add(final int quantity, final Item type) {
        final int newQuantity = this.inventory.getQuantity(type) + quantity;
        this.inventory.setQuantity(type, newQuantity);
    }

    /**
     * Creates and initializes a new Inventory instance.
     *
     * @return
     */
    @Override
    public Inventory create() {
        final Inventory newInventory = new Inventory();

        newInventory.setQuantities(new int[Item.values().length]);

        return newInventory;
    }

    /**
     * Returns true if the specified inventory contains at least the specified
     * quantity of the specified type of item.
     *
     * @param quantity
     * @param type
     * @return
     */
    public boolean has(final int quantity, final Item type) {
        return this.inventory.getQuantity(type) >= quantity;
    }

    @Override
    public Inventory getResource() {
        return this.inventory;
    }

    /**
     * Removes the specified quantity of the specified type of item to the
     * specified inventory. Does not permit the inventory to contain negative
     * quantity values.
     *
     * @param quantity
     * @param type
     */
    public void remove(final int quantity, final Item type) {
        int prev = this.inventory.getQuantity(type);
        int next = prev - quantity;
        this.inventory.setQuantity(type, (next >= 0) ? next : 0);
    }

    public int sum(final Function<Item, Integer> method) {
        int total = 0;

        for (final Item type : Item.values()) {
            total += method.apply(type) * this.inventory.getQuantity(type);
        }

        return total;
    }
}
