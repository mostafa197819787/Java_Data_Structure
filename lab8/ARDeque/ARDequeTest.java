import org.junit.Test;
import static org.junit.Assert.*;

public class ARDequeTest {

    @Test
    public void testLABEXERCISE() {
        ARDeque<String> deque = new ARDeque<>();
        assertTrue(deque.isEmpty());
        assertEquals(0, deque.size());
        assertEquals(4, deque.itemsLength());
        deque.addLast("a");
        deque.addLast("b");
        deque.addLast("c");
        deque.addLast("d");
        assertEquals(4, deque.size());
        assertEquals(4, deque.itemsLength());
        assertEquals("a", deque.get(0));
        assertEquals("b", deque.get(1));
        assertEquals("c", deque.get(2));
        assertEquals("d", deque.get(3));
        deque.addLast("e");
        assertEquals(5, deque.size());
        assertEquals(8, deque.itemsLength());
        assertEquals("a", deque.get(0));
        assertEquals("d", deque.get(3));
        assertEquals("e", deque.get(4));
    }
	

    @Test
    public void testCopyConstructor() {
        ARDeque<String> deque = new ARDeque<>();
        deque.addFirst("a");
        ARDeque<String> copyDeque = new ARDeque<>(deque);
        deque.addFirst("x");
        copyDeque.addFirst("y");
        assertEquals("x", deque.get(0));
        assertEquals("a", deque.get(1));
        assertEquals("y", copyDeque.get(0));
        assertEquals("a", copyDeque.get(1));
    }

    
    @Test
    public void testGetIndexOutOfBoundsException() {
        ARDeque<String> deque = new ARDeque<>();
        deque.addFirst("a");
        try {
            deque.get(1);
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index 1 is not valid", e.getMessage());
        }
    }
    
	// add your own unit tests,  testing each of your methods separately!
	@Test
    public void test(){
        ARDeque<String> deque = new ARDeque<>();
        for (int i = 0; i < 8; i++){
            deque.addFirst("test");
        }
        assertEquals(8, deque.size());
        assertEquals(8, deque.itemsLength());
        deque.addLast("test");
        assertEquals(9, deque.size());
        assertEquals(16, deque.itemsLength());
        deque.addFirst("test");
        assertEquals(10, deque.size());
        assertEquals(16, deque.itemsLength());
        for (int i = 0; i < 5; i++){
            deque.delFirst();
        }
        assertEquals(5, deque.size());
        assertEquals(16, deque.itemsLength());
        deque.delLast();
        assertEquals(4, deque.size());
        assertEquals(8, deque.itemsLength());
        deque.delFirst();
        assertEquals(3, deque.size());
        assertEquals(8, deque.itemsLength());
        deque.delLast();
        assertEquals(2, deque.size());
        assertEquals(4, deque.itemsLength());
    }
	
	@Test
    public void test1(){
        ARDeque<String> deque = new ARDeque<>();
        ARDeque<String> copyEmptyDeque = new ARDeque<>(deque);
        System.out.println(copyEmptyDeque.size());
        System.out.println(copyEmptyDeque.itemsLength());
        deque.addFirst("b");
        deque.addFirst("a");
        System.out.println(copyEmptyDeque.size());

        ARDeque<String> copyDeque = new ARDeque<>(deque);
        System.out.println(copyDeque.get(0));
        System.out.println(copyDeque.get(1));
        deque.addLast("c");
        System.out.println(copyEmptyDeque.isEmpty());
        System.out.println(copyDeque.get(0));
        System.out.println(copyDeque.get(1));
        try {
            System.out.println(copyDeque.get(2));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(copyDeque.size());
    }
	
	
}
