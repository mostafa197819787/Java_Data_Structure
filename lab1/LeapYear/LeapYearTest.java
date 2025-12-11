import org.junit.Test;
import static org.junit.Assert.*;

public class LeapYearTest {

    @Test
    public void testLeapYear(){
        int year = 2020;
        assertEquals(true, LeapYear.isLeapYear(2020));

        year = 0;
        assertEquals(true, LeapYear.isLeapYear(0));
    }

    @Test
    public void testNonLeapYear(){
        int year = 2019;
        assertEquals(false, LeapYear.isLeapYear(2019));
    }
    
}