import org.junit.Test;
import static org.junit.Assert.*;

public class ConcatContainTest {

    @Test
    public void testConcatContain1() {
        int expectedNumOfConcat = 2;
        assertEquals(expectedNumOfConcat, ConcatContain.concatContain("ab", "baba"));
    }

    @Test
    public void testConcatContain2() {
        assertEquals(-1, ConcatContain.concatContain("ab", "abcde"));
    }

    // add more test cases ...

    @Test
    public void testConcatContain3(){
        assertEquals(0, ConcatContain.concatContain("a","a"));
        assertEquals(-1, ConcatContain.concatContain("a","b"));
    }

    @Test
    public void testConcatContain4(){
        assertEquals(5, ConcatContain.concatContain("abc","cabcabcabcabca"));
    }

    @Test
    public void testConcatContain5(){
        assertEquals(-1,ConcatContain.concatContain("abc","abcb"));
    }

    @Test
    public void testConcatContain6(){
        assertEquals(0,ConcatContain.concatContain("abcdabcd","abcd"));
    }

    @Test
    public void testConcatContain7(){
        assertEquals(1,ConcatContain.concatContain("abcdef","efabc"));
    }
}