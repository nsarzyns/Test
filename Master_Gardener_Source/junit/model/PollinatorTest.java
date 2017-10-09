package model;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class PollinatorTest {
    Pollinator p1, p2, p3, p4, p5, p6, p7;

    @Before
    public void setup()
    {
        p1 = new Pollinator(2444, "Bungle Tree", "Grossopotamus");
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentExceptionTest()
    {
        // All arguments fail check
        p2 = new Pollinator(-1, "", "");

        // Two arguments fail check
        p3 = new Pollinator(-1, "Bungle Tree", "");

        // A different two arguments fail check
        p4 = new Pollinator(1, "", "");

        // One argument fails check
        p5 = new Pollinator(-1,"Bungle Tree", "Grossopotamus");

        // A different argument fails check
        p6 = new Pollinator(1, "Bungle Tree", "");

        // A different argument fails check
        p7 = new Pollinator(1, "", "Grossopotamus");
    }

    @Test
    public void getPollinatorIDTest()
    {
        assertEquals(p1.getPollinatorID(), 2444);
    }

    @Test
    public void getPollinatorNameTest()
    {
        assertEquals(p1.getPollinatorName(), "Bungle Tree");
    }

    @Test
    public void getPollinatorTypeTest()
    {
        assertEquals(p1.getPollinatorType(), "Grossopotamus");
    }
}
