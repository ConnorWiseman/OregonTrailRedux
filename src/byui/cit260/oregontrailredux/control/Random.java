package byui.cit260.oregontrailredux.control;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Random {
    public static int range(final int min, final int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
