package byui.cit260.oregontrailredux.control;

import byui.cit260.oregontrailredux.model.Ox;

public final class OxController implements ControllerInterface {
    
    private final Ox ox;
    
    public OxController() {
        this.ox = new Ox();
    }
    
    public OxController(final Ox ox) {
        this.ox = ox;
    }

    @Override
    public Ox create() {
        return new Ox();
    }

    public boolean canPull() {
        return this.ox.isAlive() && (this.ox.getExhaustion() < 100);
    }
    
    @Override
    public Ox getResource() {
        return this.ox;
    }
}
