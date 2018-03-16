package byui.cit260.oregontrailredux.control;

import byui.cit260.oregontrailredux.model.Wagon;

public final class WagonControl {

    private WagonControl() {
    }

    public static Wagon create() {
        return new Wagon();
    }

    public static int calculateTotalWeight(final Wagon wagon) {
        return wagon.getOwnWeight();
    }
}
