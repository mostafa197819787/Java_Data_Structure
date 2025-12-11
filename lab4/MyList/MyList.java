public class MyList {
    private int value;
    private MyList next;

    public MyList(int value, MyList next) {
        this.value = value;
        this.next = next;
    }

    // LAB EXERCISE 4.1 MYLIST ITERATIVE SQUARE MUTATE 

    /**
     * Square the elements of a MyList. Mutates the MyList.
     * @param list is a MyList object.
     */
    /*public static void iterSquareMutList(MyList list) {

		while(list != null){
            list.value = list.value * list.value;
            list = list.next;
        }

    }*/

    public static void iterSquareMutList (MyList list) {
        while (list != null){
            list.value = list.value * list.value;
            list = list.next;
        }
    }


    // LAB EXERCISE 4.2 MYLIST RECURSIVE SQUARE MUTATE 

    /**
     * Square the elements of a MyList. Mutates the MyList.
     * @param list is a MyList object.
     */
    /*public static void recSquareMutList(MyList list) {

        // base case
        if (list == null){}

		else if (list.next == null)
            list.value = list.value * list.value;

        // recursive step
		else{
            list.value = list.value * list.value;
            recSquareMutList(list.next);
        }
		
    }*/

    public static void recSquareMutList (MyList list) {
        if (list == null){}
        else if (list.next == null)
            list.value = list.value * list.value;

        else{
            list.value = list.value * list.value;
            recSquareMutList(list.next);
        }
    }


    // LAB EXERCISE 4.3 MYLIST ITERATIVE SQUARE IMMUTATE 

    /**
     * Square the elements of a MyList. Does not mutate the MyList.
     * @param list is a MyList object.
     * @return another MyList with all of input MyList's element squared.
     */
    /*public static MyList iterSquareList(MyList list) {
		if (list == null)
            return null;

        MyList res = new MyList(list.value * list.value, null);

        MyList pointer = res;
        list = list.next;
		
		while (list != null){
            pointer.next = new MyList(list.value * list.value, null);
            list = list.next;
            pointer = pointer.next;
        }

        return res;
    }*/

    public static MyList iterSquareList (MyList list) {
        if (list == null)
            return null;

        MyList result = new MyList(list.value * list.value, null);
        MyList pointer = result;
        list = list.next;

        while (list != null) {
            pointer.next = new MyList(list.value * list.value, null);
            list = list.next;
            pointer = pointer.next;
        }

        return result;
    }


    // LAB EXERCISE 4.4 MYLIST RECURSIVE SQUARE IMMUTATE 

    /**
     * Square the elements of a MyList. Does not mutate the MyList.
     * @param list is a MyList object.
     * @return another MyList with all of input MyList's element squared.
     */
    /*public static MyList recSquareList(MyList list) {

        // base case
		if (list == null)
            return null;

        // recursive step
        return new MyList(list.value * list.value, recSquareList(list.next));

    }*/

    public static MyList recSquareList (MyList list) {
        if (list == null)
            return null;

        else
            return new MyList(list.value * list.value, recSquareList(list.next));
    }


    // EXERCISE 4.1 MYLIST ITERATIVE CATENATE MUTATE 

    /**
     * Catenate two MyLists, listA and listB. Mutate listA.
     * @param listA is a MyList object.
     * @param listB is a MyList object.
     * @return a list consisting of the elements of listA followed by the
     * elements of listB.
     */
    /*public static MyList iterCatMutList(MyList listA, MyList listB) {

        MyList pointer = listA;

        // case 1: both null
        if (listA == null && listB == null)
            return null;

        // case 2: A is null
        else if (listA == null && listB != null)
            return listB;

        // case 3: B is null
        else if (listB == null && listA != null)
            return listA;

        // case 4: basic condition
        else{
            while (pointer.next != null)
                pointer = pointer.next;

            pointer.next = new MyList(listB.get(0), null);
            pointer = pointer.next;

            // add listB's elements to listA
            for (int i = 1; i < listB.iterSize(); i++){
                pointer.next = new MyList(listB.get(i), null);
                pointer = pointer.next;
            }

            return listA;
        }

    }*/

    public static MyList iterCatMutList (MyList listA, MyList listB) {
        if (listA == null && listB == null)
            return null;

        else if (listA == null && listB != null)
            return listB;

        else if (listA != null && listB == null)
            return listA;

        else{
            MyList pointer = listA;

            while (pointer.next != null)
                pointer = pointer.next;

            pointer.next = new MyList(listB.get(0), null);
            pointer = pointer.next;

            for (int k = 1; k < listB.iterSize(); k++){
                pointer.next = new MyList(listB.get(k), null);
                pointer = pointer.next;
            }

            return listA;
        }
    }


    // EXERCISE 4.2 MYLIST RECURSIVE CATENATE MUTATE 

    /**
     * Catenate two MyLists, listA and listB. Mutate listA.
     * @param listA is a MyList object.
     * @param listB is a MyList object.
     * @return a list consisting of the elements of listA followed by the
     * elements of listB.
     */
    /*public static MyList recCatMutList(MyList listA, MyList listB) {

        // base case
		if (listA == null && listB == null) // both null
            return null;

        else if (listA == null && listB != null) // A is null
            return listB;

        else if (listB == null && listA != null) // B is null
            return listA;

        else{ // both not null
            if (listA.next == null){

                listA.next = listB;
                listB = listB.next;

                return listA;
            }
        }

        // recursive step
		return new MyList(listA.value, recCatMutList(listA.next, listB));

    }*/

    public static MyList recCatMutList (MyList listA, MyList listB) {
        if (listA == null && listB == null)
            return null;

        else if (listA == null && listB != null)
            return listB;

        else if (listA != null && listB == null)
            return listA;

        else{
            if (listA.next == null){
                listA.next = listB;
                listB = listB.next;

                return listA;
            }
        }

        return new MyList(listA.value, recCatMutList(listA.next, listB));
    }


    // EXERCISE 4.3 MYLIST ITERATIVE CATENATE IMMUTATE 

    /**
     * Catenate two MyLists, listA and listB. Does not mutate listA.
     * @param listA is a MyList object.
     * @param listB is a MyList object.
     * @return a list consisting of the elements of listA followed by the
     * elements of listB.
     */
    /*public static MyList iterCatList(MyList listA, MyList listB) {
		// both null
        if (listA == null && listB == null)
            return null;

        // A is null
        else if (listA == null && listB != null)
            return listB;

        // B is null
        else if (listB == null && listA != null)
            return listA;

        // both not null
        else{
            MyList pointerA;
            MyList pointerB;
            MyList result;
            result = new MyList(listA.get(0), null);
            pointerA = result;

            for (int i = 1; i < listA.iterSize(); i++){
                pointerA.next = new MyList(listA.get(i), null);
                pointerA = pointerA.next;
            }

            pointerB = pointerA;
            for (int i = 0; i < listB.iterSize(); i++){
                pointerB.next = new MyList(listB.get(i), null);
                pointerB = pointerB.next;
            }

            return result;
        }

    }*/
    public static MyList iterCatList (MyList listA, MyList listB) {
        if (listA == null && listB == null)
            return null;
        else if (listA == null && listB != null)
            return listB;
        else if (listB == null && listA != null)
            return listA;
        else{
            MyList result = new MyList(listA.get(0), null);
            MyList pointerA = result;
            MyList pointerB;

            for (int i = 1; i < listA.iterSize(); i++){
                pointerA.next = new MyList(listA.get(i), null);
                pointerA = pointerA.next;
            }

            pointerB = pointerA;
            for (int i = 0; i < listB.iterSize(); i++) {
                pointerB.next = new MyList(listB.get(i), null);
                pointerB = pointerB.next;
            }

            return result;

        }
    }


    // EXERCISE 4.4 MYLIST RECURSIVE CATENATE IMMUTATE 

    /**
     * Catenate two MyLists, listA and listB. Does not mutate listA.
     * @param listA is a MyList object.
     * @param listB is a MyList object.
     * @return a list consisting of the elements of listA followed by the
     * elements of listB.
     */
    /*public static MyList recCatList(MyList listA, MyList listB) {

        // base case
        // both null
		if (listA == null && listB == null)
            return null;

        // B is null
        else if (listA != null && listB == null)
            return listA;

        // A is null
        else if (listB != null && listA == null)
            return listB;

        // both not null
		else{
            if (listA.next == null)
                return new MyList(listA.value, listB);
        }

        // recursive step
        return new MyList(listA.value, recCatList(listA.next, listB));

    }*/

    public static MyList recCatList (MyList listA, MyList listB) {
        if (listA == null && listB == null)
            return null;
        else if (listA == null && listB != null)
            return listB;
        else if (listB == null && listA != null)
            return listA;
        else{
            if (listA.next == null)
                return new MyList(listA.value, listB);

            return new MyList(listA.value, recCatList(listA.next, listB));
        }
    }



    /*
     *
     *****  Do NOT modify the codes below from the lecture notes!  *****
     *****  Only for your JUnit Testing purposes!                  *****
     *
     */


    /**
     * @return the size of the MyList iteratively.
     */
    public int iterSize() {
        MyList p = this;
        int size = 0;
        while (p != null) {
            size += 1;
            p = p.next;
        }
        return size;
    }

    /**
     * @return the size of the MyList recursively.
     */
    public int recSize() {
        // base case
        if (next == null) {
            return 1;
        }
        // recursive step
        return 1 + this.next.recSize();
    }

    /**
     * @param i is a valid index of MyList.
     * @return the ith value of this MyList.
     */
    public int get(int i) {
        // base case
        if (i == 0) {
            return value;
        }
        // recursive step
        return next.get(i - 1);
    }

    /**
     * @param args is a variable number of integers.
     * @return a new MyList containing the integers in args.
     */
    public static MyList ofEntries(Integer... args) {
        MyList result, p;
        if (args.length > 0) {
            result = new MyList(args[0], null);
        } else {
            return null;
        }
        int k;
        for (k = 1, p = result; k < args.length; k += 1, p = p.next) {
            p.next = new MyList(args[k], null);
        }
        return result;
    }

    /**
     * @param l is a MyList object.
     * @return true iff l is a MyList object containing the same sequence of
     * integers as this.
     */
    public boolean equals(Object l) {
        if (!(l instanceof MyList)) {
            return false;
        }
        MyList list = (MyList) l;
        MyList p;
        for (p = this; p != null && list != null; p = p.next, list = list.next) {
            if (p.value != list.value) {
                return false;
            }
        }
        if (p != null || list != null) {
            return false;
        }
        return true;
    }

    public String toString() {
        int size = this.recSize();
        String output= "[";
        for (int i = 0; i < size; i++) {
            output = output + this.get(i);
            if (i != size-1)
                output = output + ", ";
        }
        output = output + "]";
        return output;
    }
	
	
}
