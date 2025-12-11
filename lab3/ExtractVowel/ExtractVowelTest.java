import org.junit.Test;
import static org.junit.Assert.*;

public class ExtractVowelTest {
    @Test
    public void testExtractVowels() {
        String str = "i love you 3000";
        assertEquals("ioeou", ExtractVowel.extractVowel(str));
        assertEquals("aiueo", ExtractVowel.extractVowel("aiueo"));
    }
    
	// add your own test cases
	
	
	
}
