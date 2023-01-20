package pro.tyshchenko.oop.hashtables;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Alexander Tyshchenko.
 */
public class TreeMapExample {

    public static void main(String[] args) {
        Map<String, String> unsortedMap = new HashMap<>();
        unsortedMap.put("Z", "z");
        unsortedMap.put("B", "b");
        unsortedMap.put("A", "a");
        unsortedMap.put("C", "c");
        unsortedMap.put("D", "d");
        unsortedMap.put("E", "e");
        unsortedMap.put("Y", "y");
        unsortedMap.put("N", "n");
        unsortedMap.put("J", "j");
        unsortedMap.put("M", "m");
        unsortedMap.put("F", "f");

        System.out.println("Unsorted map " + unsortedMap);

        Map<String, String> treeMap = new TreeMap<>(unsortedMap);

        System.out.println("Sorted map " + treeMap);

        treeMap.put("G", "g");

        System.out.println("Sorted map after adding some element " + treeMap);

        unsortedMap.put("O", "o");

        System.out.println("Unsorted map after adding some element " + unsortedMap);


    }

}
