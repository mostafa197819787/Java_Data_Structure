import org.junit.Test;
import static org.junit.Assert.*;

public class DelDuplicateTest {

    @Test
    public void test1(){
        String word = "aaabbc";
        assertEquals("abc", DelDuplicate.delDuplicate(word));
    }

    @Test
    public void test2(){
        String word = "aaaaa";
        assertEquals("a", DelDuplicate.delDuplicate(word));
    }

    @Test
    public void test3(){
        String word = "";
        assertEquals("", DelDuplicate.delDuplicate(word));
    }

    @Test
    public void test4(){
        String word = "     ";
        assertEquals(" ", DelDuplicate.delDuplicate(word));
    }

}
