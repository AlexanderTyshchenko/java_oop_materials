package pro.tyshchenko.oop.hashtables;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Alexander Tyshchenko.
 */
public class HashSetExample {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("B");
        set.add("A");
        set.add("D");
        set.add("E");
        set.add("C");
        set.add("F");

        System.out.println("Initial set " + set);

        set.add("B");
        set.add("E");
        set.add("F");

        System.out.println("Set after adding some elements " + set);
    }

}
