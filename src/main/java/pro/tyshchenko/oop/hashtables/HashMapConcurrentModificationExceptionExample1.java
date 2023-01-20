package pro.tyshchenko.oop.hashtables;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alexander Tyshchenko.
 */
public class HashMapConcurrentModificationExceptionExample1 {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();

        // Insert some sample key-value pairs.
        map.put("Key1", 1);
        map.put("Key2", 2);
        map.put("Key3", 3);

          /* Remove a value of the map, while iterating over it.
           * The following code throws a java.util.ConcurrentModificationException. */
        map.keySet().forEach( (k) -> {
            if(map.get(k) == 1)
                map.remove(k);
        });
        System.out.println("Successfully removed a pair!");
    }

}
