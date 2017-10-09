package model;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class PollinatorVisitCountTest {
    PollinatorVisitCount p1, p2;

    @Before
    public void setup()
    {
        p1 = new PollinatorVisitCount(5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentExceptionTest()
    {
        p2 = new PollinatorVisitCount(-1);
    }

    @Test
    public void getPollinatorVisitCountTest()
    {
        assertEquals(p1.getCount(), 5);
    }

}
