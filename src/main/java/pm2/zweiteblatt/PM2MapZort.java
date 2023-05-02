/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pm2.zweiteblatt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Implementation of PM2Map without using for-each loops
 * @author yunussozeri
 */
public class PM2MapZort<K, V> implements Map<K, V> {

    private MapPaar<K, V>[] pairs;
    //private int size;
    private int size;

    public PM2MapZort() {
        this.pairs = new MapPaar[10];
        //size = pairs.length;
        size = 0;
    }

    /**
     * PM2Map Constructor with generic MapPaar array parameter.
     *
     * @param pairs
     */
    public PM2MapZort(MapPaar<K, V>[] pairs) {
        this.pairs = pairs;
        //size = pairs.length;
        size = 0;
    }

    /**
     * Returns the size of the Map. This gives information on how many
     * elements are contained in the PM2Map.
     *
     * @return size, the number of elements
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Tells if the PM2Map is empty.
     *
     * @return true, if there is no elements contained. false, if there are some
     * elements contained.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {

        for (int i = 0; i < size; i++) {
            if (pairs[i].getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (int i = 0; i < size; i++) {
            if (pairs[i].getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        for (int i = 0; i < size; i++) {
            if (pairs[i].getKey().equals(key)) {
                return pairs[i].getValue();
            }
        }
        return null;
    }

    /**
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public V put(K key, V value) {
        if (containsKey(key)) {
            for (int i = 0; i < size; i++) {
                var pair = pairs[i];
                if (pair.getKey().equals(key)) {
                    var oldValue = pair.getValue();
                    pair.setValue(value);
                    // return the old value
                    return oldValue;
                }
            }

        }
        // check size
        if (isFull()) {
            // increase size if needed
            increaseSize();
        }
        MapPaar<K, V> pair = new MapPaar<>(key, value);
        // add element to map
        pairs[size] = pair;
        // increase size
        size++;
        // add new element to the next index
        return null;
    }
    private boolean isFull() {
        return size == pairs.length;
    }

    /**
     * Doubles the size of the generic MapPaar array.
     */
    private void increaseSize() {
        MapPaar<K, V>[] largerArray = new MapPaar[pairs.length * 2];
        System.arraycopy(pairs, 0, largerArray, 0, pairs.length);
        pairs = largerArray;
    }

    /**
     * Adds all elements in the given Map to PM2Map
     *
     * @param m is the map of elements
     */
    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        // source: https://stackoverflow.com/questions/46898/how-do-i-efficiently-iterate-over-each-entry-in-a-java-map
        m.forEach((key, value) -> put(key, value));
    }

    /**
     * Clears the Map by removing elements in the MapPaar array.
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            pairs[i] = null;
        }
        size = 0;
    }

    @Override
    public Set keySet() {
        // create a set to store the keys
        Set<K> keys = new HashSet<>();
        for (int i = 0; i < size; i++) {
                var pair = pairs[i];
                // get the current key
                K currKey = pair.getKey();
                // add to the set
                keys.add(currKey);
        }
        // return the keys
        return keys;
    }

    @Override
    public Collection values() {
        Collection values = new ArrayList<V>();
        for (int i = 0; i < size; i++) { // loop through pairs
                var pair = pairs[i];
                // get the current value
                V currVal = pair.getValue();
                // add to the list
                values.add(currVal);
            }
        
        return values;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> entries = new HashSet<>();
        var pairsAsList = Arrays.asList(pairs);

        // go through each pair and add the pair to the set
        pairsAsList.forEach((pair) -> entries.add(pair));
        // remove null by hand bcs standard size may cause problems
        entries.remove(null);

        return entries;
    }

    @Override
    public V remove(Object key) {
        int index = 0;
        if (containsKey(key)) {
            for (int i = 0; i < size; i++) {
                var pair = pairs[i];
                if (pair.getKey().equals(key)) {
                    V oldValue = pair.getValue();
                        //replace current pair with an empty pair
                        pairs[index] = null;
                        // decrease size by one
                        size--;
                        shiftToLeftFrom(index);
                        // return the old value
                        return oldValue;
                        } else{ // increment index until key is found
                        index++;
                    }
                }
            }
        return null;
    }
    public void shiftToLeftFrom(int index){
        
        for(int i=index; i< size;i++){
            pairs[i]=pairs[i+1];
        }
    }

}
