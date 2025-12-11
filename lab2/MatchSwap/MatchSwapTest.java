import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;


public class MatchSwapTest {
	@Test
    public void testMatch(){
        List<String> list = Arrays.asList("apple", "avocado");
        List<String> excepted = Arrays.asList("avocado", "apple");
        assertEquals(excepted, MatchSwap.matchSwap(list));

        list = Arrays.asList("ab", "ac", "ad", "ae", "af");
        excepted = Arrays.asList("ac", "ab", "ae", "ad", "af");
        assertEquals(excepted, MatchSwap.matchSwap(list));

        list = Arrays.asList("ap", "bp", "cp", "aq", "cq", "bq");
        excepted = Arrays.asList("aq", "bq", "cq", "ap", "cp", "bp");
        assertEquals(excepted, MatchSwap.matchSwap(list));

        list = Arrays.asList("ap", "bp", "cp", "dq", "eq", "fq");
        excepted = Arrays.asList("ap", "bp", "cp", "dq", "eq", "fq");
        assertEquals(excepted, MatchSwap.matchSwap(list));

        list = Arrays.asList();
        excepted = Arrays.asList();
        assertEquals(excepted, MatchSwap.matchSwap(list));
    }
}