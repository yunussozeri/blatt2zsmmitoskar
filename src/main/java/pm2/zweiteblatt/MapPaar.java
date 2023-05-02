
package pm2.zweiteblatt;

import java.util.Map;

/**
 *
 * @author yunussozeri
 */
public class MapPaar <K,V> implements Map.Entry<K, V>{

    private final K key;
    private V value;
    
    public MapPaar(){
        this.key = (K)"LEER";
        
    }
    
    public MapPaar(K key, V value){
        this.key=key;
        this.value = value;
    }
    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
       V previous = this.value;
       this.value = (V) value;
       return previous;
    }
    
    public boolean isEmpty(){
        return key.equals((K)"LEER");
    }
}
