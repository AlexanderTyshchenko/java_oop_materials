package pro.tyshchenko.oop.hashtables;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Alexander Tyshchenko.
 */
public class LinkedHashMapExample {

    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();

        map.put("2", "value2");
        map.put("1", "value1");
        map.put("3", "value3");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("Key=" + entry.getKey() + " Value=" + entry.getValue());
        }

        System.out.println(map);
    }

}
