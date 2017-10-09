package model;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class DateTest {
    Date d1, d2, d3, d4, d5;

    @Before
    public void setup()
    {
        d1 = new Date(31, 11, 2015);
        d2 = new Date(23, 2, 2013);
        //Test this by creating an object in the tests
        //d3 = new Date(13, 5, 2012); //this test should receive an illegal argument exception
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentExceptionTest()
    {
        d3 = new Date(13, 5, 2012);
        d4 = new Date(32, 2, 2013);
        d5 = new Date(31, 13, 2014);
    }

    @Test
    public void stringifyDateTest()
    {
        assertEquals(d1.stringifyDate(), "11/31/2015");
        assertEquals(d2.stringifyDate(), "2/23/2013");
    }

    @Test
    public void getDayTest()
    {
        assertEquals(d1.getDay(), 31);
        assertEquals(d2.getDay(), 23);
    }

    @Test
    public void getMonthTest()
    {
        assertEquals(d1.getMonth(), 11);
        assertEquals(d2.getMonth(), 2);
    }
    @Test
    public void getYearTest()
    {
        assertEquals(d1.getYear(), 2015);
        assertEquals(d2.getYear(), 2013);
    }

}
