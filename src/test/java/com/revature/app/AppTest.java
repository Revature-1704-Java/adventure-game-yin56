package com.revature.app;


import static org.junit.Assert.*;
import org.junit.Test;
//import com.revature.beans.*;
/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    @Test
    public final void directionValid(){
        Room r1 = null;
        boolean valid = App.checkRoomValid(r1);
        assertEquals(false, valid);
    
    }
    

    @Test
    public final void roomNumberCorrect(){
        int count = App.getRoomCount(3, 3);
        assertEquals(9, count);

        count = App.getRoomCount(3, 4);
        assertEquals(12, count);

        count = App.getRoomCount(20, 5);
        assertEquals(100, count);
    }
    

}
