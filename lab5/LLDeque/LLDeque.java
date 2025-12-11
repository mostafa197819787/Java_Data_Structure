public class LLDeque<T> {

    private class Node {
        Node prev;
        T item;
        Node next;

        Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private Node sentinel;
    private int size;

    /**
     * @return the number of items in the deque.
     */
    public int size() {
        return size;
    }

    /**
     * @return true if deque is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /*
     ***************************
     * DO NOT MODIFY CODE ABOVE
     ***************************
     */


    // LAB EXERCISE 5.1 EMPTY CONSTRUCTOR

    /**
     * Creates an empty deque.
     */
    public LLDeque() {

		sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;

    }


    // LAB EXERCISE 5.2 ADD TO FRONT

    /**
     * Adds an item of type T to the front of the deque.
     * @param item is a type T object added to the deque.
     */
    public void addFirst(T item) {
		
		Node node = new Node(sentinel, item, sentinel.next);
        sentinel.next.prev = node;
        sentinel.next = node;
		size += 1;

    }


    // LAB EXERCISE 5.3 PRINT ITEMS

    /**
     * Prints the items in the deque from first to last,
     * separated by a space, ended with a new line.
     */
    public void printDeque() {

        Node p = sentinel.next;
		while (p != sentinel){
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();

    }


    // LAB EXERCISE 5.4 ITERATIVE GET ITEM

    /**
     * Gets the item at the given index.
     * If no such item exists, returns null.
     * Does not mutate the deque.
     * @param index is an index where 0 is the front.
     * @return the ith item of the deque, null if it does not exist.
     */
    public T iterGet(int index) {

        if (size == 0 || index < 0 || index >= size)
            return null;

		Node p = sentinel.next;
        while (index > 0){
            p = p.next;
            index -= 1;
        }

        return p.item;

    }

    // EXERCISE 5.1 ADD TO BACK

    /**
     * Adds an item of type T to the back of the deque.
     * @param item is a type T object added to the deque.
     */
    public void addLast(T item) {
		
		Node node = new Node(null, item, null);

        node.prev = sentinel.prev;
        node.next = sentinel;
        sentinel.prev.next = node;
        sentinel.prev = node;

        size += 1;
		
    }


    // EXERCISE 5.2 DELETE FRONT

    /**
     * Deletes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     * @return the first item of the deque, null if it does not exist.
     */
    public T delFirst() {
		
		if (sentinel.next == null || sentinel.next.item == null)
            return null;

        Node node = sentinel.next;
        //sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;

        size -= 1;
        return node.item;

    }


    // EXERCISE 5.3 DELETE BACK

    /**
     * Deletes and returns the item at the back  of the deque.
     * If no such item exists, returns null.
     * @return the last item of the deque, null if it does not exist.
     */
    public T delLast() {

        if (sentinel.next == null || sentinel.next.item == null)
            return null;

        Node node = sentinel.prev;
        sentinel.prev = sentinel.prev.prev;
        //sentinel.prev.next = sentinel;

        size -= 1;
        return node.item;

    }

    // EXERCISE 5.4 RECURSIVE GET ITEM

    /**
     * Gets the item at the given index.
     * If no such item exists, returns null.
     * Does not mutate the deque.
     * @param index is an index where 0 is the front.
     * @return the ith item of the deque, null if it does not exist.
     */
    public T recGet(int index) {

		if (size == 0 || index < 0 || index >= size)
            return null;

        if (index == 0){
            Node node = sentinel.next;
            return node.item;
        }

        sentinel = sentinel.next; // next point, 进入迭代状态,实际是这行在移动点。
        T ans = recGet(index - 1);
        sentinel = sentinel.prev; // 恢复sentinel, not mutate, so need to create a new node = sentinel.next

        return ans;

    }
	

    public static void main(String[] args) {
        LLDeque<String> deque = new LLDeque<>();
        deque.addFirst("b");
        deque.addFirst("a");
        //deque.delFirst();
        deque.delLast();
        deque.printDeque();
    }

}
