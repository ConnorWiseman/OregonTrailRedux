package byui.cit260.oregontrailredux.control.util;

import java.util.concurrent.ThreadLocalRandom;

/**
 * A class for generating random numbers.
 *
 * @author Connor
 */
public final class Random {

    /**
     * Private constructor prevents direct instantiation.
     */
    private Random() {
    }

    /**
     * Returns a random integer between min and max, inclusive.
     *
     * @param min
     * @param max
     * @return
     */
    public static int range(final int min, final int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
