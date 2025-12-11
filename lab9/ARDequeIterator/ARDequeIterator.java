public class ARDequeIterator<T> {

    private final ARDeque<T> deque;
    private int index;


    /*
     ***************************
     * DO NOT MODIFY CODE ABOVE
     ***************************
     */


    // LAB EXERCISE 9.1 CONSTRUCTOR AND HASNEXT

    /**
     * Make an iterator.
     * @param deque deque to iterate over
     */
    /*public ARDequeIterator( ARDeque<T> deque ) {
		
		this.deque = deque;
        this.index = 0;
		
    }*/
    public ARDequeIterator (ARDeque<T> deque) {
        this.deque = deque;
        this.index = 0;
    }

    /**
     * Test whether the iterator has more items to return.
     * @return true if next() will return another item,
     *         false if all items have been returned
     */
    /*
    public boolean hasNext() {
		
		return index < deque.size();
		
    }*/

    public boolean hasNext() {
        return index < deque.size(); // whether next pointer to the not null, not the length of deque
    }


    // LAB EXERCISE 9.2 NEXT

    /**
     * Get the next item of the deque.
     * Requires: hasNext() returns true.
     * Modifies: this iterator to advance it to the item
     *           following the returned item.
     * @return next item of the deque
     */
    /*public T next() {

        final T item = deque.get(index); // to get the item asked for
        index++; // move the iterator to the next one of this one taken

        return item;
		
    }*/

    public T next() {
        T item = deque.get(index);
        index++;

        return item;
    }


    public static void main(String[] args) {
        ARDeque<String> deque = new ARDeque<>();
        deque.addLast("a");
        deque.addLast("b");
        deque.addLast("c");

        ARDequeIterator<String> iter = new ARDequeIterator<>(deque);
        while (iter.hasNext()) {
            String str = iter.next();
            System.out.print(str + " ");
        }
        System.out.println();
		
    }
}