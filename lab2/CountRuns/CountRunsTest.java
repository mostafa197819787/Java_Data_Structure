import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class CountRunsTest {
	
	// add test cases
	@Test
    public void test1(){
        List<Integer> list = Arrays.asList(1, 2, 2, 2, 3);
        assertEquals(1, CountRuns.countRuns(list));

        list = Arrays.asList(1, 1, 2, 3, 4, 5, 5);
        assertEquals(2, CountRuns.countRuns(list));

        list = Arrays.asList(2, 3, 5, 1, 3);
        assertEquals(0, CountRuns.countRuns(list));

        list = Arrays.asList(0, 0, 0, 1, 2);
        assertEquals(1, CountRuns.countRuns(list));

        list = Arrays.asList(1, 3, 3, 2, 2);
        assertEquals(2, CountRuns.countRuns(list));

        list = Arrays.asList(0, 0, 4, 5, 5, 4, 3, 3);
        assertEquals(3, CountRuns.countRuns(list));

        list = Arrays.asList();
        assertEquals(0, CountRuns.countRuns(list));

        list = Arrays.asList(2, 2, 2, 3, 3);
        assertEquals(2, CountRuns.countRuns(list));
    }
	
	
}