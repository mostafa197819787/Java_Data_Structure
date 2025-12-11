public class LLDeque<T> { // 连接：本质就是让这个item的前后进行连接

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


    // EXERCISE 6.1 COPY CONSTRUCTOR

    /**
     * Creates a (deep) copy of another Deque object.
	 * @param other is another LLDeque<T> object.
     */
    /*public LLDeque(LLDeque<T> other) {

        this();
        Node q = other.sentinel;

        while (q.next != null && q.next.item != null) {
            this.addLast(q.next.item);
            q = q.next;
        }
		
    }*/
    public LLDeque(LLDeque<T> other) {
        this();
        Node q = other.sentinel;

        while(q.next != null && q.next.item != null) {
            this.addLast(q.next.item);
            q = q.next;
        }
    }


    // EXERCISE 6.2 ADD NOT NULL TO FRONT

    /**
     * Adds an non-null item of type T to the front of the deque.
     * @param item is a type T object.
     * @throws IllegalArgumentException if the item is null.
     */
    /*public void addFirst(T item) {
		
		if (item == null){
            throw new IllegalArgumentException();
        }
        else{
            Node node = new Node(sentinel, item, sentinel.next);
            sentinel.next.prev = node;
            sentinel.next = node;
            size += 1;
        }
		
    }*/

    public void addFirst (T item) {
        if (item == null)
            throw new IllegalArgumentException();
        else {
            Node node = new Node(sentinel, item, sentinel.next);
            sentinel.next.prev = node;
            sentinel.next = node;
            size += 1;
        }
    }

    private T delLast() {
        if(this.sentinel==null||this.size<=0) {
            return null;
        }
        Node last2Node = this.sentinel.prev.prev;
        Node targetNode = this.sentinel.prev;
        T target = targetNode.item;
        last2Node.next = this.sentinel;
        this.sentinel.prev = last2Node;
        targetNode.next = null;
        targetNode.prev = null;
        return target;
    }

    @SuppressWarnings("unchecked")
    public void addN (T item, int index, int n) {
        if (item == null)
            throw new IllegalArgumentException();

        else {
            T[] items = (T[])new Object[this.size() - index];
            int count = this.size() - index - 1;
            while(this.size() > index) {
                items[count] = this.delLast();
                this.delLast();
                count--;
                this.size --;
            }
            for (int i = 0; i < n; i++) {
                this.addLast(item);
            }
            for (int i = 0; i < items.length; i++) {
                this.addLast(items[i]);
            }
        }
    }


    // EXERCISE 6.3 ADD LEGAL ITEM TO FRONT

    /**
     * Adds the first item of type T to the front of the deque,
     * or the second item of type T instead if the first item is illegal.
     * @param item1 is a type T object.
     * @param item2 is a type T object.
     */
    /*public void addLegalFirst(T item1, T item2) {
		try{
            this.addFirst(item1);
        }
        catch(IllegalArgumentException exp){
            this.addFirst(item2);
        }

    }*/

    public void addLegalFirst(T item1, T item2) {
        try {
            this.addFirst(item1);
        }
        catch (IllegalArgumentException exp) {
            this.addFirst(item2);
        }
    }

	
    /*
     *************************************************************
     * You can copy paste Lab 5 codes below if you want to use it
     *************************************************************
     */
    public LLDeque() {

        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;

    }


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

    public void addLast(T item) {

        Node node = new Node(null, item, null);

        node.prev = sentinel.prev;
        node.next = sentinel;
        sentinel.prev.next = node;
        sentinel.prev = node;

        size += 1;

    }

    public void printDeque() {

        Node p = sentinel.next;
        while (p != sentinel){
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();

    }

}
