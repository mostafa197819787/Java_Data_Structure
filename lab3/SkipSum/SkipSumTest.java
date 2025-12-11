import org.junit.Test;

import java.util.List;
import java.util.Arrays;

import static org.junit.Assert.*;

public class SkipSumTest {
    
	@Test
    public void test1(){
        List<Integer> list = Arrays.asList(2, 5, 10, 6);
        assertTrue(SkipSum.skipSum(list, 12));
    }

    @Test
    public void test2(){
        List<Integer> list = Arrays.asList(2, 5, 10, 6);
        assertFalse(SkipSum.skipSum(list, 7));
    }

    @Test
    public void test3(){
        List<Integer> list = Arrays.asList(2, 5, 10, 6);
        assertFalse(SkipSum.skipSum(list, 16));
    }

    @Test
    public void test4(){
        List<Integer> list = Arrays.asList(2, 5, 10, 6);
        assertTrue(SkipSum.skipSum(list, 0));
    }

    @Test
    public void test5(){
        List<Integer> list = Arrays.asList();
        assertTrue(SkipSum.skipSum(list, 0));
    }

    @Test
    public void test6(){
        List<Integer> list = Arrays.asList(0, 1, 1);
        assertTrue(SkipSum.skipSum(list, 0));
    }
}
