package map;

import list.AbstractList;
import list.Node;

/**
 *
 * @author Georgiana
 */
public abstract class AbstractHashMap {
    
    protected AbstractList[] buckets;
    
    /**
     * 
     * @param key the key searched for
     * @return the list of values mapped by {@code key}.
     */
    public abstract AbstractList get(Key key);
    
    /**
     * 
     * @param key the key searched for
     * @return {@code true} if the key exists in the Hash Map, {@code false} otherwise
     */
    public abstract boolean containsKey(Key key);
    
    /**
     * Inserts a new pair ({@code key}, {@code value}) to the Hash Map.
     * If an entry for the given key exists, the value is added in its list of 
     * values. The list of values should be kept sorted.
     * When the load factor reaches a certain threshold, the size of the internal 
     * array is doubled, and entries are reassigned to buckets
     * @param key
     * @param value
     * @return {@code true} if the key did not exist in the Hash Map before, 
     * {@code false} otherwise. This value could be used to keep track of the 
     * number of entries in the Hash Map in order to decide when to perform a 
     * resizing of the array
     */
    public abstract boolean put(Key key, Value value);
    
    /**
     * Removes the pair ({@code key}, {@code value}) from the Hash Map
     * @param key
     * @param value
     * @return the number of appearances of {@code value} for {@code key}
     */
    public abstract int remove(Key key, Value value);
    
    /**
     * Removes all values for the given key.
     * @param key
     * @return the list of values that were present in the Hash Map for the given key
     */
    public abstract AbstractList remove(Key key);
}