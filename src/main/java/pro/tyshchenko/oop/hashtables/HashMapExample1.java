package pro.tyshchenko.oop.hashtables;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alexander Tyshchenko.
 */
public class HashMapExample1 {

//    private Map<Integer, String> map = new HashMap<Integer, String>() {
//        {
//            put(1, "value1");
//            put(2, "value2");
//            put(3, "value3");
//        }
//    };

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("2", "value2");
        map.put("1", "value1");
        map.put("3", "value3");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("Key=" + entry.getKey() + " Value=" + entry.getValue());
        }

        System.out.println(map);

//        Java 8
//        map.forEach((k, v) -> System.out.println("Key=" + k + " Value=" + v));

        // iterating over keys only
        for (String key : map.keySet()) {
            System.out.println("Key=" + key);
        }
//        Java 8
//        map.keySet().forEach((k) -> System.out.println("Key=" + k));

        // iterating over values only
        for (String value : map.values()) {
            System.out.println("Value=" + value);
        }
//        Java 8
//        map.values().forEach((v) -> System.out.println("Value=" + v));

        map.put(null, "nullValue1");
        System.out.println(map.get(null));

    }

}
