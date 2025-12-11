import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

public class OddAndTenTest {
    
	@Test
    public void test1(){
        List<Integer> list = Arrays.asList(5, 5, 3);
        assertTrue(OddAndTen.oddAndTen(list));
    }

    @Test
    public void test2(){
        List<Integer> list = Arrays.asList(5, 5, 4);
        assertFalse(OddAndTen.oddAndTen(list));
    }

    @Test
    public void test3(){
        List<Integer> list = Arrays.asList(5, 5, 4, 1);
        assertTrue(OddAndTen.oddAndTen(list));
    }
}
