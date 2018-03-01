package byui.cit260.oregontrailredux.control;

import byui.cit260.oregontrailredux.model.Ox;
import byui.cit260.oregontrailredux.model.Oxen;
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
        Ox left, right;
        Oxen oxen;
        int expResult, result;
        
        System.out.println("valid, no exhaustion #1");
        left   = new Ox(5);
        right  = new Ox(7);
        oxen   = new Oxen(left, right);
        expResult = 24;
        result    = OxenControl.calculatePullCapacity(oxen);
        assertEquals(expResult, result);
        
        System.out.println("valid, no exhaustion #2");
        left   = new Ox(1);
        right  = new Ox(9);
        oxen   = new Oxen(left, right);
        expResult = 20;
        result    = OxenControl.calculatePullCapacity(oxen);
        assertEquals(expResult, result);
        
        System.out.println("valid, no exhaustion #3");
        left   = new Ox(0);
        right  = new Ox(5);
        oxen   = new Oxen(left, right);
        expResult = 10;
        result    = OxenControl.calculatePullCapacity(oxen);
        assertEquals(expResult, result);
        
        System.out.println("valid, exhaustion #1");
        left   = new Ox(3);
        right  = new Ox(15);
        oxen   = new Oxen(left, right);
        left.setExhaustion(10);
        expResult = 34;
        result    = OxenControl.calculatePullCapacity(oxen);
        assertEquals(expResult, result);
        
        System.out.println("valid, exhaustion #2");
        left   = new Ox(4);
        right  = new Ox(2);
        oxen   = new Oxen(left, right);
        left.setExhaustion(10);
        right.setExhaustion(100);
        expResult = 5;
        result    = OxenControl.calculatePullCapacity(oxen);
        assertEquals(expResult, result);
        
        System.out.println("valid, exhaustion #3");
        left   = new Ox(5);
        right  = new Ox(7);
        oxen   = new Oxen(left, right);
        left.setExhaustion(100);
        right.setExhaustion(100);
        expResult = 0;
        result    = OxenControl.calculatePullCapacity(oxen);
        assertEquals(expResult, result);
    }
}
