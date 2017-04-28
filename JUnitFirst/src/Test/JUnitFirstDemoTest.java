package Test;

//µ¥Ôª²âÊÔ
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import org.junit.Ignore;

public class JUnitFirstDemoTest {

    private static JUnitFirstDemo calculator = new JUnitFirstDemo();
    
    @Before
    public void setUp() throws Exception {
        calculator.clear();
    }

    @Test
    public void testAdd() {
        calculator.add(2);
        calculator.add(3);
        assertEquals(5, calculator.getResult());
    }

    @Test
    public void testSubstract() {
        calculator.add(10);
        calculator.substract(2);
        assertEquals(9, calculator.getResult());
    }

    @Ignore("Multiply() Not yet implemented")
    @Test
    public void testMultiply() {
    }

    @Test
    public void testDivide() {
        calculator.add(8);
        calculator.divide(2);
        assertEquals(4, calculator.getResult());
    }
}
