package pm2.zweiteblatt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author yunussozeri
 */
public class PM2MapTest {

    private PM2Map testmap = new PM2Map();

    public PM2MapTest() {

    }

    /**
     * Test of size method, of class PM2Map.
     */
    @Test
    public void testSize() {

        testmap.put("A", 1);
        testmap.put("B", 2);
        testmap.put("C", 3);
        testmap.put("D", 4);
        int result = testmap.size();
        int expResult = 4;
        assertEquals(expResult, result);

        testmap.put("E", 5);
        testmap.put("F", 6);
        testmap.put("G", 7);
        testmap.put("H", 8);

        result = testmap.size();
        expResult = 8;
        assertEquals(expResult, result);
        testmap.put("I", 9);
        testmap.put("J", 10);

        result = testmap.size();
        expResult = 10;
        assertEquals(expResult, result);
    }

    @Test
    public void testSizeEmpty() {

        testmap.clear();
        assertEquals(0, testmap.size());
    }

    /**
     * Test of isEmpty method, of class PM2Map.
     */
    @Test
    public void testIsEmpty() {

        boolean expResult = false;
        testmap.put("a", 1);
        boolean result = testmap.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of containsKey method, of class PM2Map.
     */
    @Test
    public void testContainsKeyNegative() {

        String key = "A";
        testmap.put("B", 5);
        boolean expResult = false;
        boolean result = testmap.containsKey(key);
        assertEquals(expResult, result);

    }

    @Test
    public void testContainsKeyPositive() {

        String key = "A";
        testmap.put(key, 0);
        boolean expResult = true;
        boolean result = testmap.containsKey(key);
        assertEquals(expResult, result);

    }

    /**
     * Test of containsValue method, of class PM2Map.
     */
    @Test
    public void testContainsValuePositive() {

        Integer value = 6;
        testmap.put("A", value);
        boolean expResult = true;
        boolean result = testmap.containsValue(value);
        assertEquals(expResult, result);
    }

    @Test
    public void testContainsValueNegative() {

        Integer value = 5;
        testmap.put("A", 6);
        boolean expResult = false;
        boolean result = testmap.containsValue(value);
        assertEquals(expResult, result);
    }

    /**
     * Test of get method, of class PM2Map.
     */
    @Test
    public void testGet() {

        String key = "A";
        Integer value = 5;
        testmap.put(key, value);
        Object expResult = 5;
        Object result = testmap.get(key);
        assertEquals(expResult, result);
    }

    /**
     * Test of put method, of class PM2Map.
     */
    @Test
    public void testPut() {

        String key = "A";
        Integer value = 1;
        testmap.put(key, value);
        assertEquals(value, testmap.put(key, 2));
    }

    /**
     * Test of remove method, of class PM2Map.
     */
    @Test
    public void testRemove() {

        String[] keyArr = {"A", "yunus", "oskar"};
        testmap.put(keyArr[0], 1);
        testmap.put(keyArr[1], 31);
        testmap.put(keyArr[2], 32);

        testmap.remove(keyArr[0]);
        assertEquals(2, testmap.size());

    }

    @Test
    public void testRemoveAllByHand() {

        String[] keyArr = {"A", "yunus", "oskar"};
        testmap.put(keyArr[0], 1);
        testmap.put(keyArr[1], 31);
        testmap.put(keyArr[2], 32);

        testmap.remove(keyArr[0]);
        testmap.remove(keyArr[1]);
        
        assertEquals(1, testmap.size());
        testmap.remove(keyArr[2]);

        assertEquals(0, testmap.size());
    }

    @Test
    public void testRemoveNonExistentKey() {

        String[] keyArr = {"A", "yunus", "oskar", "Meine wille zum Leben"};
        testmap.put(keyArr[0], 1);
        testmap.put(keyArr[1], 31);
        testmap.put(keyArr[2], 32);

        assertEquals(null, testmap.remove(keyArr[3]));
    }

    /**
     * Test of putAll method, of class PM2Map.
     */
    @Test
    public void testPutAll() {

        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        testmap.putAll(map);
        Set<String> expectedKeys = map.keySet();

        assertEquals(3, testmap.size());
        assertEquals(1, map.get("A"));
        assertEquals(2, map.get("B"));
        assertEquals(3, map.get("C"));

        map.put("D", 4);
        map.put("E", 5);

        testmap.putAll(map);

        assertEquals(5, testmap.size());
        assertEquals(4, map.get("D"));
        assertEquals(5, map.get("E"));

        assertEquals(expectedKeys, testmap.keySet());

    }

    @Test
    public void testPutAllEmptyMap() {

        Map<String, Integer> emptyMap = new HashMap<>();
        testmap.putAll(emptyMap);

        assertTrue(testmap.isEmpty());
    }

    /**
     * Test of clear method, of class PM2Map.
     */
    @Test
    public void testClear() {

        String[] keyArr = {"A", "yunus", "oskar"};
        testmap.put(keyArr[0], 1);
        testmap.put(keyArr[1], 31);
        testmap.put(keyArr[2], 32);
        testmap.clear();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(0, testmap.size());
    }

    /**
     * Test of values method, of class PM2Map.
     */
    @Test
    public void testValuesEmptyMap() {

        Collection<Integer> expectedValues = new ArrayList<>();
        assertEquals(expectedValues, testmap.values());
    }

    @Test
    public void testValuesNonEmptyMap() {

        testmap.put("A", 1);
        testmap.put("B", 2);
        testmap.put("C", 3);
        Collection<Integer> expectedValues = new ArrayList<>();
        expectedValues.add(1);
        expectedValues.add(2);
        expectedValues.add(3);
        assertEquals(expectedValues, testmap.values());
    }

    @Test
    public void testValuesMapWithNullValues() {

        testmap.put("A", null);
        testmap.put("B", null);
        Collection<Integer> expectedValues = new ArrayList<>();
        expectedValues.add(null);
        expectedValues.add(null);
        assertEquals(expectedValues, testmap.values());
    }

    /**
     * Test of entrySet method, of class PM2Map.
     */
    @Test
    public void testEntrySet() {

        testmap.put("A", 1);
        testmap.put("B", 2);
        testmap.put("C", 3);

        // Test the entry set
        Set<Entry<String, Integer>> entries = testmap.entrySet();
        assertEquals(3, entries.size());

        // Test the contents of the entry set
        for (Entry<String, Integer> entry : entries) {
            assertTrue(testmap.containsKey(entry.getKey()));
            assertTrue(testmap.containsValue(entry.getValue()));
        }
    }

    @Test
    void testEmptyEntrySet() {

        // Test the entry set of an empty map
        Set<Entry<String, Integer>> entries = testmap.entrySet();
        assertTrue(entries.isEmpty());
    }

    /**
     * Test of keySet method, of class PM2Map.
     */
    @Test
    public void testKeySet() {

        String[] keyArr = {"A", "yunus", "oskar"};
        testmap.put(keyArr[0], 1);
        testmap.put(keyArr[1], 31);
        testmap.put(keyArr[2], 32);

        Set keys = testmap.keySet();

        assertEquals(true, keys.contains(keyArr[0]));
        assertEquals(true, keys.contains(keyArr[1]));
        assertEquals(true, keys.contains(keyArr[2]));

    }

    @Test
    public void testKeySetEmpty() {
        assertTrue(testmap.keySet().isEmpty());
    }

    @Test
    public void testKeySetSingle() {

        testmap.put("foo", 42);
        assertTrue(testmap.keySet().contains("foo"));
    }

    @Test
    public void testKeySetMultiple() {

        testmap.put("foo", 42);
        testmap.put("bar", 99);
        testmap.put("baz", -1);
        assertTrue(testmap.keySet().containsAll(Set.of("foo", "bar", "baz")));
    }

    @Test
    public void testKeySetNullKey() {

        testmap.put(null, 42);
        Set<String> expectedKeys = new HashSet<>();
        expectedKeys.add(null);
        assertEquals(expectedKeys, testmap.keySet());
    }

    @Test
    public void testKeySetDuplicateKeys() {

        testmap.put("foo", 42);
        testmap.put("foo", 99);
        assertTrue(testmap.keySet().contains("foo"));
        assertEquals(1, testmap.keySet().size());
    }

}
