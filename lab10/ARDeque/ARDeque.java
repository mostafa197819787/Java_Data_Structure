import java.util.Iterator;

public class ARDeque<T> implements Deque<T>, Iterable<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /**
     * @return the size of the array used in the deque.
     */
    public int itemsLength() {
        return items.length;
    }

    /**
     * @return the number of items in the deque.
     */
    @Override
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


    /*
     ***** HELPER METHODS START *****
     */

    // add your own helper methods here
    private int plusOne (int index) { return (index + 1) % items.length; }
    private int minusOne (int index) { return (index - 1 + items.length) % items.length; }

    /* Resizes the underlying array to the target capacity. */
    @SuppressWarnings("unchecked")
    private void resize(int capacity) {

        // Create mew object with c and empty
        T[] newArray = (T[]) new Object[capacity];

        // Make a new index to store the current index
        int curr = plusOne(nextFirst);
        for (int i = 0; i < size; i++){
            newArray[i] = items[curr]; // copy element from old item to my new array one by one
            curr = plusOne(curr); // move curr pointer to the next one, within the items limit
        }

        // Update variables s
        items = newArray;
        nextFirst = capacity - 1;
        nextLast = size;

    }
	
	
	
	// INCLUDE in your submission
	// if you use them in your method

    /*
     ***** HELPER METHODS END *****
     */
	 
	 
	// add your own ARDeque codes from previous labs



    /**
     * Creates an empty deque.
     */
    @SuppressWarnings("unchecked")
    public ARDeque() {

        items = (T[]) new Object[4];
        size = 0;
        nextFirst = 0;
        nextLast = 1;

    }


    // LAB EXERCISE 8.2 ADD TO BACK

    /**
     * Adds an item of type T to the back of the deque.
     * @param item is a type T object to be added.
     */
    @Override
    public void addLast(T item) {

        if (size == items.length){
            resize(2 * size);
        }

        items[nextLast] = item;
        size += 1;
        nextLast = plusOne(nextLast);

    }


    // LAB EXERCISE 8.3 PRINT ITEMS

    /**
     * Prints the items in the deque from first to last,
     * separated by a space, ended with a new line.
     */
    @Override
    public void printDeque() {

        int i = plusOne(nextFirst);
        for (int j = 0; j < size; j++){
            System.out.print(items[i] + " ");
            i = plusOne(i);
        }
        System.out.println();

    }


    // LAB EXERCISE 8.4 GET ITEM

    /**
     * Gets the item at the given index.
     * Does not mutate the deque.
     * @param index is an index where 0 is the front.
     * @return the index-th item of the deque.
     * @throws IndexOutOfBoundsException if no item exists at the given index.
     */
    @Override
    public T get(int index) {

        if (size == 0 || index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index " + index + " is not valid");

        index = (plusOne(nextFirst) + index) % items.length;
        return items[index];

    }


    // EXERCISE 8.1 ADD TO FRONT

    /**
     * Adds an item of type T to the front of the deque.
     * @param item is a type T object to be added.
     */
    public void addFirst(T item) {

        if (size == items.length)
            resize(2 * size);

        items[nextFirst] = item;
        size += 1;
        nextFirst = minusOne(nextFirst);

    }


    // EXERCISE 8.2 DELETE FRONT

    /**
     * Deletes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     * @return the first item of the deque, null if it does not exist.
     */
    @Override
    public T delFirst() {

        if (size == 0)
            return null;

        int index = plusOne(nextFirst);
        T item = items[index];
        nextFirst = plusOne(nextFirst);
        size -= 1;

        if (size <= items.length / 4 )
            resize(items.length / 2);

        return item;

    }


    // EXERCISE 8.3 DELETE BACK

    /**
     * Deletes and returns the item at the back  of the deque.
     * If no such item exists, returns null.
     * @return the last item of the deque, null if it does not exist.
     */
    @Override
    public T delLast() {

        if (size == 0)
            return null;

        int index = minusOne(nextLast);
        T item = items[index];
        nextLast = minusOne(nextLast);
        size -= 1;

        if (size <= items.length / 4)
            resize(items.length / 2);

        return item;

    }
	
	// CODING ASSIGNMENT 10.3  ITERATOR

    /**
     * Make an iterator
     */
    /*@Override
    public Iterator<T> iterator() {
        return new ARDequeIterator();
    }

    private class ARDequeIterator implements Iterator<T> {

        private int index;
        private int count;

        public ARDequeIterator(){
            index = plusOne(nextFirst);
            count = 0;
        }

        @Override
        public boolean hasNext(){ return count < size; }

        @Override
        public T next(){
            T item = items[index];
            index = plusOne(index);
            count = count + 1;
            return item;
        }

    }*/

    @Override
    public Iterator<T> iterator() {
        return new ARDequeIterator();
    }

    private class ARDequeIterator implements Iterator<T> {
        private int index; // not the real index
        private int count;

        public ARDequeIterator(){
            index = plusOne(nextFirst);
            count = 0;
        }

        public boolean hasNext() {
            return count < size;
        }

        public T next() {
            T nextItem = items[index];
            index = plusOne(index);
            count++;
            return nextItem;
        }
    }

    public static void main(String[] args){
        ARDeque<String> deque = new ARDeque<>();
        deque.addLast("a");
        deque.addLast("b");
        deque.addLast("c");
        for (String item : deque) {
            System.out.print(item + " ");
        }
    }

}