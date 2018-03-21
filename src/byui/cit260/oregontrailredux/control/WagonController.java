package byui.cit260.oregontrailredux.control;

import byui.cit260.oregontrailredux.model.Wagon;

public final class WagonController {

    private final Wagon wagon;

    public WagonController(final Wagon wagon) {
        this.wagon = wagon;
    }
    
    public static Wagon create() {
        final Wagon newWagon = new Wagon();
        
        newWagon.setCargo(InventoryController.create());
        
        return newWagon;
    }

    public int calculateTotalWeight() {
        return this.wagon.getOwnWeight();
    }
}
