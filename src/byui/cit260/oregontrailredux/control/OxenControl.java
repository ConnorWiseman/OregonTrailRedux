package byui.cit260.oregontrailredux.control;

import byui.cit260.oregontrailredux.enums.OxPosition;
import byui.cit260.oregontrailredux.enums.Pace;
import byui.cit260.oregontrailredux.model.Ox;
import byui.cit260.oregontrailredux.model.Oxen;
import java.lang.reflect.Field;

/**
 * Controls the Oxen class.
 * @author Connor
 */
public abstract class OxenControl {
    
    /**
     * Uses reflection to calculate the total value of the specified target
     * property of the provided pair of Oxen. Implemented to cut down on
     * practically identical but specialized methods and to play with
     * reflection because it's some pretty fun stuff.
     * @param oxen
     * @param target
     * @return
     */
    private static int sumTotal(final Oxen oxen, final String target) {
        int total = 0;
        
        try {
            for (final Ox current: oxen.getOxen()) {
                Field field = current.getClass().getDeclaredField(target);
                field.setAccessible(true);
                total += (int) field.get(current);
            }
        } catch(IllegalAccessException | IllegalArgumentException |
                NoSuchFieldException | SecurityException e) {
            // Log the exception?
        }
        
        return total;
    }
    
    /**
     * Applies exhaustion to the specified pair of Oxen. Takes the weight the
     * pair of Oxen are pulling and the pace at which they are pulling it into
     * account for the calculation.
     * @param oxen
     * @param weight
     * @param pace
     */
    public static void applyExhaustion(final Oxen oxen, final int weight,
            final Pace pace) {
        // how tired are the oxen from pulling x amount of weight at y pace?
        // does the stronger ox get tired faster? It ought to!
    }
    
    /**
     * Calculates the pull capacity of the specified pair of Oxen.
     * @param oxen
     * @return
     */
    public static int calculatePullCapacity(final Oxen oxen) {
        int totalStrength   = OxenControl.sumTotal(oxen, "strength");
        int totalExhaustion = OxenControl.sumTotal(oxen, "exhaustion");
        
        return (int) ((totalStrength * 2.0) *
                (double) ((200.0 - totalExhaustion) / 200.0));
    }
    
    /**
     * Determines whether the specified pair of Oxen can pull.
     * @param oxen
     * @return
     */
    public static boolean canPull(final Oxen oxen) {
        return OxControl.canPull(oxen.get(OxPosition.LEFT)) ||
                OxControl.canPull(oxen.get(OxPosition.RIGHT));
    }
    
    /**
     * Determines whether the specified pair of Oxen can pull the specified
     * amount of weight.
     * @param oxen
     * @param weight
     * @return
     */
    public static boolean canPullWeight(final Oxen oxen, final int weight) {
        return OxenControl.calculatePullCapacity(oxen) > weight;
    }
    
    /**
     * Counts the number of Ox in the pair of Oxen. An Ox only counts toward
     * the total if it is alive; any dead Ox must be replaced.
     * @param oxen
     * @return
     */
    public static int count(final Oxen oxen) {
        int num = 0;
        
        for (final Ox current: oxen.getOxen()) {
            num += (current.isAlive())  ? 1 : 0;
        }

        return num;
    }
    
    /**
     * Creates a pair of Oxen from two separate Ox.
     * @param left
     * @param right
     * @return
     */
    public static Oxen create(final Ox left, final Ox right) {
        return new Oxen(left, right);
    }
}
