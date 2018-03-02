package byui.cit260.oregontrailredux.control;

import byui.cit260.oregontrailredux.model.enums.Item;
import byui.cit260.oregontrailredux.model.Inventory;
import java.lang.reflect.Field;

/**
 * Controls the Inventory class.
 *
 * @author Connor
 */
public abstract class InventoryControl {

    /**
     * Adds the specified quantity of the specified type of item to the
     * specified inventory.
     *
     * @param quantity
     * @param type
     * @param inventory
     */
    public static void addToInventory(final int quantity, final Item type,
            final Inventory inventory) {
        inventory.setQuantity(type, inventory.getQuantity(type) + quantity);
    }

    /**
     * Creates and initializes a new Inventory instance.
     *
     * @return
     */
    public static Inventory create() {
        Inventory inventory = new Inventory();
        inventory.setQuantities(new int[Item.values().length]);
        return inventory;
    }

    /**
     * Returns true if the specified inventory contains at least the specified
     * quantity of the specified type of item.
     *
     * @param inventory
     * @param quantity
     * @param type
     * @return
     */
    public static boolean hasAtLeast(final Inventory inventory,
            final int quantity, final Item type) {
        return inventory.getQuantity(type) >= quantity;
    }

    /**
     * Removes the specified quantity of the specified type of item to the
     * specified inventory. Does not permit the inventory to contain negative
     * quantity values.
     *
     * @param quantity
     * @param type
     * @param inventory
     */
    public static void removeFromInventory(final int quantity,
            final Item type, final Inventory inventory) {
        int prev = inventory.getQuantity(type);
        int next = prev - quantity;
        inventory.setQuantity(type, (next >= 0) ? next : 0);
    }

    /**
     * Uses reflection to calculate the total value of the specified target
     * property of the Item enum. Only works on properties belonging to the Item
     * enum, naturally. Implemented to cut down on practically identical but
     * specialized methods and to play with reflection because it's some pretty
     * fun stuff.
     *
     * @example int totalWeight = sumTotal(inv, "weight");
     * @param inventory
     * @param target
     * @return
     */
    public static int sumTotal(final Inventory inventory,
            final String target) {
        int total = 0;

        try {
            for (final Item type : Item.values()) {
                Field field = type.getClass().getDeclaredField(target);
                total += (int) field.get(type) * inventory.getQuantity(type);
            }
        } catch (IllegalAccessException | IllegalArgumentException
                | NoSuchFieldException | SecurityException e) {
            // Log the exception?
        }

        return total;
    }
}
