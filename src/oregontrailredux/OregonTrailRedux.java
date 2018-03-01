package oregontrailredux;

import byui.cit260.oregontrailredux.control.GameControl;
import byui.cit260.oregontrailredux.control.InventoryControl;
import byui.cit260.oregontrailredux.enums.Item;
import byui.cit260.oregontrailredux.model.Inventory;

/**
 * The project's main class.
 * @author Connor
 */
public class OregonTrailRedux {

    /**
     * The program's entry point.
     * @param args
     */
    public static void main(String[] args) {
        GameControl.startGame();
        
//        Inventory playerInventory = InventoryControl.create();
//        InventoryControl.addToInventory(5, Item.GOLD_DUST, playerInventory);
//        InventoryControl.addToInventory(10, Item.FOOD, playerInventory);
//        InventoryControl.removeFromInventory(10, Item.FOOD, playerInventory);
//        System.out.println(playerInventory);
//        
//        
//        int totalWeight = InventoryControl.sumTotal(playerInventory, "weight");
//        int totalValue  = InventoryControl.sumTotal(playerInventory, "value");
// 
//        System.out.println("Weight: " + totalWeight + "lbs");
//        System.out.println("Value:  $" + totalValue);
//        
//        int minimum = 5;
//        if (InventoryControl.hasAtLeast(playerInventory, minimum, Item.FOOD)) {
//            System.out.println("We have at least " + minimum + " food!");
//        } else {
//            System.out.println("We'll all starve!");
//        }
    }
}
