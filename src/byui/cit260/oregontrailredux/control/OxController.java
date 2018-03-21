package byui.cit260.oregontrailredux.control;

import byui.cit260.oregontrailredux.model.Ox;

public final class OxController {
    
    private final Ox ox;
 
    public OxController(final Ox ox) {
        this.ox = ox;
    }

    public static Ox create() {
        return new Ox();
    }

    public boolean canPull() {
        return this.ox.isAlive() && (this.ox.getExhaustion() < 100);
    }
}
