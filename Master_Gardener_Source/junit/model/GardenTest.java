package model;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class GardenTest {
    Garden g1, g2, g3;

    @Before
    public void setup()
    {
        g1 = new Garden(2,"343 Main Road Avenue Lane");
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentExceptionTest()
    {
        g2 = new Garden(1, "");
        g3 = new Garden(-1, "boo 420");
    }

    @Test
    public void getGardenAddressTest()
    {
        assertEquals(g1.getGardenAddress(), "343 Main Road Avenue Lane");
    }

    @Test
    public void getGardenID()
    {
        assertEquals(g1.getGarden_id(), 2);
    }
}
