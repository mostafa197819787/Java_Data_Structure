import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 *  Hash-based Map
 */
public class HAMap<K, V> implements Iterable<K> {

    /**
     * Represents a key-value pair.
     */
    private class Entry {
        K key;
        V value;

        Entry(K k, V v) {
            key = k;
            value = v;
        }
    }

    private static final int DEFAULT_CAPACITY = 16;
    private static final double DEFAULT_LOAD_FACTOR = 1.5;

    private ArrayList<ArrayList<Entry>> buckets;
    private HashSet<K> keySet;
    private int numBuckets;
    private int numEntries;
    private final double loadFactor;

    /**
     * @return a set of the keys contained in this map.
     */
    public HashSet<K> keySet() {
        return keySet;
    }

    /**
     * @return the number of entries in this map.
     */
    public int size() {
        return numEntries;
    }

    /**
     * @return the number of buckets in this map.
     */
    public int getNumBuckets() {
        return numBuckets;
    }

    /*
     ***************************
     * DO NOT MODIFY CODE ABOVE
     ***************************
     */


    /*
     ***** HELPER METHODS START *****
     */

    
	// INCLUDE your helper methods in EACH of your submissions that use them
	private int reduce(K key, int capacity){
        return Math.floorMod(key.hashCode(), capacity);
    } // get the index

    private void resize(int newCapacity){
        // To make new empty bucket
        ArrayList<ArrayList<Entry>> newBucket = new ArrayList<>();

        for (int i = 0; i < newCapacity; i++){
            newBucket.add(new ArrayList<>());
        }

        // rehashing
        int index;
        for (K key: this){
            index = reduce(key, newCapacity);
            newBucket.get(index).add(new Entry(key, get(key)));
        }

        buckets = newBucket;
        numBuckets = newCapacity;
    }

    /*
     ***** HELPER METHODS END *****
     */


    // LAB EXERCISE 12.2 CONSTRUCTORS
/*
    public HAMap(int initialCapacity, double loadFactor) {
        buckets = new ArrayList<>();
        keySet = new HashSet<>();
        numBuckets = initialCapacity;
        numEntries = 0;

        this.loadFactor = loadFactor;

        for (int i = 0; i < numBuckets; i++){
            buckets.add(new ArrayList<>());
        }
    }

    public HAMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public HAMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }
*/
    public HAMap (int initialCapacity, double loadFactor) {
        buckets = new ArrayList<>();
        keySet = new HashSet<>();
        numBuckets = initialCapacity;
        numEntries = 0;

        this.loadFactor = loadFactor;

        for (int i = 0; i < numBuckets; i++) {
            buckets.add(new ArrayList<>());
        }
    }

    public HAMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public HAMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    // LAB EXERCISE 12.3 CLEAR

    /**
     * Removes all of the entries from this map.
     */
    /*public void clear() {
		buckets = new ArrayList<>();
        keySet = new HashSet<>();
        numEntries = 0;

        for (int i = 0; i < numBuckets; i++){
            buckets.add(new ArrayList<>());
        }
    }*/

    public void clear() {
        buckets = new ArrayList<>();
        keySet = new HashSet<>();
        numEntries = 0;

        for (int i = 0; i < numBuckets; i++) {
            buckets.add(new ArrayList<>());
        }
    }


    // LAB EXERCISE 12.4 CONTAINS KEY and ITERATOR

    /**
     * @param key to be checked
     * @return true iff this map contains an entry with the specified key
     */
    /*
    public boolean containsKey(K key) {
		return keySet.contains(key);
    }
*/

    /**
     * @return an Iterator that iterates over the stored keys
     */
    /*
    @Override
    public Iterator<K> iterator() {
		return keySet.iterator();
    }
*/
    public boolean containsKey(K key) {
        return keySet.contains(key);
    }

    @Override
    public Iterator<K> iterator() {
        return keySet.iterator();
    }

    // CODING ASSIGNMENT 12.1 GET

    /**
     * @param key of the value to be returned
     * @return the value to which the specified key is mapped
     *         null if this map contains no entries of the key
     */
    /*public V get(K key) {
		if (key != null && containsKey(key)){
            int index = reduce(key, numBuckets);
            ArrayList<Entry> entries = buckets.get(index);
            for (Entry item: entries){
                if (item.key.equals(key))
                    return item.value;
            }
        }

        // return null
		return null;
    }*/

    public V get(K key) {
        if (key != null && containsKey(key)) {
            int index = reduce(key, numBuckets);
            ArrayList<Entry> entries = buckets.get(index);
            for (Entry item: entries) {
                if (item.key.equals(key))
                    return item.value;
            }
        }
        return null;
    }


    // CODING ASSIGNMENT 12.2 PUT

    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained an entry with that key, the old value is replaced.
     * The key is not null.
     * @param key of the entry to be added
     * @param value of the entry to be added
     */
    /*public void put(K key, V value) {
		double rate = (double) numEntries / numBuckets;

        if (rate >= loadFactor)
            resize(numBuckets * 2);

        int index = reduce(key, numBuckets);
        if (!containsKey(key)){
            keySet.add(key);
            buckets.get(index).add(new Entry(key, value));
            numEntries += 1;
        }
        else{
            for (int i = 0; i < buckets.get(index).size(); i++){
                if (buckets.get(index).get(i).key.equals(key))
                    buckets.get(index).get(i).value = value;
            }
        }
    }*/

    public void put(K key, V value) {
        double rate = (double) numEntries / numBuckets;

        if (rate >= loadFactor)
            resize(numBuckets * 2);

        int index = reduce(key, numBuckets);
        if (!containsKey(key)){
            keySet.add(key);
            buckets.get(index).add(new Entry(key, value));
            numEntries += 1;
        }
        else {
            for (int i = 0; i < buckets.get(index).size(); i++) {
                if (buckets.get(index).get(i).key.equals(key))
                    buckets.get(index).get(i).value = value;
            }
        }
    }
	
	
    // CODING ASSIGNMENT 12.3 REMOVE

    /**
     * Removes the entry for the specified key only if it is
     * currently mapped to the specified value.
     * @param key of the entry to be removed
     * @param value of the entry to be removed
     * @return the value if entry found,
     *         null otherwise
     */
    /*public V remove(K key, V value) {
		if (containsKey(key)){
            int index = reduce(key, numBuckets);
            for (int i = 0; i < buckets.get(index).size(); i++){
                if (buckets.get(index).get(i).key.equals(key)){
                    if (buckets.get(index).get(i).value.equals(value)){
                        Entry item = buckets.get(index).remove(i);
                        keySet.remove(key);
                        numEntries -= 1;
                        return item.value;
                    }
                }
            }
        }

        // return null
		return null;
    }*/

    public V remove(K key, V value) {
        if (containsKey(key)){
            int index = reduce(key, numBuckets);
            for (int i = 0; i < buckets.get(index).size(); i++) {
                if (buckets.get(index).get(i).key.equals(key)){
                    if (buckets.get(index).get(i).value.equals(value)){
                        Entry item = buckets.get(index).remove(i);
                        keySet.remove(key);
                        numEntries -= 1;
                        return item.value;
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args){
        HAMap<Integer, String> map = new HAMap<>(32);
        System.out.println(map.size());
        System.out.println(map.get(0));
        System.out.println("setsize=" + map.keySet().size());
        map.put(0, "a");
        System.out.println(map.get(0));
        System.out.println("size=" + map.size());
        System.out.println("nkuckets=" + map.getNumBuckets());
        System.out.println("setsize=" + map.keySet().size());
    }

}
