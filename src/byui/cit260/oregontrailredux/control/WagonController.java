package byui.cit260.oregontrailredux.control;

import byui.cit260.oregontrailredux.model.Wagon;

public final class WagonController implements ControllerInterface {

    private final Wagon wagon;

    public WagonController() {
        this.wagon = new Wagon();
    }

    public WagonController(final Wagon wagon) {
        this.wagon = wagon;
    }

    public int calculateTotalWeight() {
        return this.wagon.getOwnWeight();
    }

    @Override
    public Wagon create() {
        final Wagon newWagon = new Wagon();
        
        newWagon.setCargo(new InventoryController().create());
        
        return newWagon;
    }

    @Override
    public Object getResource() {
        return this.wagon;
    }
}
