package byui.cit260.oregontrailredux.control;

import byui.cit260.oregontrailredux.model.enums.OxPosition;
import byui.cit260.oregontrailredux.model.enums.Pace;
import byui.cit260.oregontrailredux.model.Ox;
import byui.cit260.oregontrailredux.model.Oxen;
import java.util.function.Function;

/**
 * Controls the Oxen class.
 *
 * @author Connor
 */
public final class OxenController implements ControllerInterface {

    private final Oxen oxen;

    public OxenController() {
        this.oxen = new Oxen();
    }

    public OxenController(final Oxen oxen) {
        this.oxen = oxen;
    }


    public int sum(final Function<Ox, Integer> method) {
        int total = 0;

        for (final Ox current : this.oxen.getOxen()) {
            total += method.apply(current);
        }

        return total;
    }

    /**
     * Applies exhaustion to the specified pair of Oxen. Takes the weight the
     * pair of Oxen are pulling and the pace at which they are pulling it into
     * account for the calculation.
     *
     * @param weight
     * @param pace
     */
    public void applyExhaustion(final int weight, final Pace pace) {
        // how tired are the oxen from pulling x amount of weight at y pace?
        // does the stronger ox get tired faster? It ought to!
    }

    /**
     * Calculates the pull capacity of the specified pair of Oxen.
     *
     * @return
     */
    public int calculatePullCapacity() {
        int totalStrength = this.sum(Ox::getStrength);
        int totalExhaustion = this.sum(Ox::getExhaustion);

        return (int) ((totalStrength * 2.0)
                * (double) ((200.0 - totalExhaustion) / 200.0));
    }

    /**
     * Determines whether the specified pair of Oxen can pull.
     *
     * @return
     */
    public boolean canPull() {
        final OxController left = new OxController(oxen.get(OxPosition.LEFT));
        final OxController right = new OxController(oxen.get(OxPosition.RIGHT));

        return left.canPull() || right.canPull();
    }

    /**
     * Determines whether the specified pair of Oxen can pull the specified
     * amount of weight.
     *
     * @param weight
     * @return
     */
    public boolean canPullWeight(final int weight) {
        return this.calculatePullCapacity() > weight;
    }

    /**
     * Counts the number of Ox in the pair of Oxen. An Ox only counts toward the
     * total if it is alive; any dead Ox must be replaced.
     *
     * @return
     */
    public int count() {
        int num = 0;

        for (final Ox current : this.oxen.getOxen()) {
            num += (current.isAlive()) ? 1 : 0;
        }

        return num;
    }

    /**
     * Creates a pair of Oxen.
     *
     * @return
     */
    @Override
    public Oxen create() {
        final Oxen newOxen = new Oxen();
        final OxController oc = new OxController();

        newOxen.set(OxPosition.LEFT, oc.create());
        newOxen.set(OxPosition.RIGHT, oc.create());

        return newOxen;
    }

    @Override
    public Oxen getResource() {
        return this.oxen;
    }
}
