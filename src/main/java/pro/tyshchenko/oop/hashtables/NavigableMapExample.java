package pro.tyshchenko.oop.hashtables;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * @author Alexander Tyshchenko.
 */
public class NavigableMapExample {

    public static void main(String[] args) {
        NavigableMap<Integer, String> map = new TreeMap<>();

        map.put(1, "value1");
        map.put(2, "value2");
        map.put(3, "value2");
        map.put(5, "value3");
        map.put(6, "value4");

        Integer integer1 = map.ceilingKey(4);
        Map.Entry<Integer, String> entry = map.ceilingEntry(4);
        int a = 0;
    }

}
