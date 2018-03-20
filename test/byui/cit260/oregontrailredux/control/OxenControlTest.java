package byui.cit260.oregontrailredux.control;

import byui.cit260.oregontrailredux.model.Ox;
import byui.cit260.oregontrailredux.model.Oxen;
import byui.cit260.oregontrailredux.model.enums.OxPosition;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Connor
 */
public class OxenControlTest {

    @Test
    public void testCalculatePullCapacity() {
        System.out.println("calculatePullCapacity");
        final Ox left = new Ox();
        final Ox right = new Ox();
        final Oxen oxen = new Oxen();
        oxen.set(OxPosition.LEFT, left);
        oxen.set(OxPosition.RIGHT, right);
        final OxenController oc = new OxenController(oxen);
        int expResult, result;

        System.out.println("valid, no exhaustion #1");
        left.setStrength(5);
        right.setStrength(7);
        expResult = 24;
        result = oc.calculatePullCapacity();
        assertEquals(expResult, result);

        System.out.println("valid, no exhaustion #2");
        left.setStrength(1);
        right.setStrength(9);
        expResult = 20;
        result = oc.calculatePullCapacity();
        assertEquals(expResult, result);

        System.out.println("valid, no exhaustion #3");
        left.setStrength(0);
        right.setStrength(5);
        expResult = 10;
        result = oc.calculatePullCapacity();
        assertEquals(expResult, result);

        System.out.println("valid, exhaustion #1");
        left.setStrength(3);
        right.setStrength(15);
        left.setExhaustion(10);
        expResult = 34;
        result = oc.calculatePullCapacity();
        assertEquals(expResult, result);

        System.out.println("valid, exhaustion #2");
        left.setStrength(4);
        right.setStrength(2);
        left.setExhaustion(10);
        right.setExhaustion(100);
        expResult = 5;
        result = oc.calculatePullCapacity();
        assertEquals(expResult, result);

        System.out.println("valid, exhaustion #3");
        left.setStrength(5);
        right.setStrength(7);
        left.setExhaustion(100);
        right.setExhaustion(100);
        expResult = 0;
        result = oc.calculatePullCapacity();
        assertEquals(expResult, result);
    }
}
