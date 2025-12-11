import org.junit.Test;
import static org.junit.Assert.*;

public class CountBabaMamaTest {

	@Test
    public void test1(){
        String word = "aba babaa amama ma";
        assertEquals(2, CountBabaMama.countBabaMama(word));
    }

	@Test
    public void test2(){
        String word = "";
        assertEquals(0, CountBabaMama.countBabaMama(word));
    }

    @Test
    public void test3(){
        String word = "bababamamama";
        assertEquals(4, CountBabaMama.countBabaMama(word));
    }

    @Test
    public void test4(){
        String word = "baba";
        assertEquals(1,CountBabaMama.countBabaMama(word));
    }
}
