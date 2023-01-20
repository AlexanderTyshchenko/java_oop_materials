package pro.tyshchenko.oop.hashtables;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author Alexander Tyshchenko.
 */
public class HashtableExample {

    public static void main(String[] args) {
        Map<String, String> hashTable = new Hashtable<>();
        hashTable.put("1", "value1");
        hashTable.put("2", "value2");
        hashTable.put("3", "value3");


        // !!!????
        hashTable.put(null, "nullValue");

        hashTable.forEach((k ,v) -> System.out.println("Key=" + k + " Value=" + v));
    }

}
