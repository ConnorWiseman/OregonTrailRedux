package byui.cit260.oregontrailredux.control;

import byui.cit260.oregontrailredux.model.Ox;

public abstract class OxControl {

    public static Ox create(String name) {
        return new Ox(name, Random.range(30, 80));
    }

    public static boolean canPull(Ox ox) {
        return ox.isAlive() && (ox.getExhaustion() < 100);
    }
}
