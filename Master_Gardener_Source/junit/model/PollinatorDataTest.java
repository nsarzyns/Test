package model;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class PollinatorDataTest {

    PollinatorData p1, p2, p3, p4, p5;

    @Before
    public void setup()
    {
        //Some arguments are exaggerated and only exist to test.
        p1 = new PollinatorData(750, 1030, 75, "yes", "maybe", 12, 12, 2014);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentExceptionTest()
    {
        // First test is to test and see if the Date IllegalArgException is working
        p2 = new PollinatorData(750, 1030, 2, "yes", "maybe", 12, 29, 1012);

        // These tests are related to PollinatorData

        // 3) All Arguments fail
        p3 = new PollinatorData(-200, -100, -500, "", "", 13, 32, 1002);

        // 4) Some arguments fail
        p4 = new PollinatorData(650, 750, -500, "", "yes", 12, 12, 2014);

        // 5) One argument fails
        p5 = new PollinatorData(-1, 600, 75, "yes", "yes", 12, 12, 2014);
    }

    @Test
    public void getTimeStartTest()
    {
        assertEquals(p1.getTimeStart(), 750);
    }

    @Test
    public void getTimeStopTest()
    {
        assertEquals(p1.getTimeStop(), 1030);
    }

    @Test
    public void getTemperatureTest()
    {
        assertEquals(p1.getTemperature(), 75);
    }

    @Test
    public void getCloudTest()
    {
        assertEquals(p1.getCloudStatus(), "yes");
    }

    @Test
    public void getWindTest()
    {
        assertEquals(p1.getWindStatus(), "maybe");
    }
}
