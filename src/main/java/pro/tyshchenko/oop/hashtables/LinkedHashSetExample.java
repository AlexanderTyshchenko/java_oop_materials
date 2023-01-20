package pro.tyshchenko.oop.hashtables;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Alexander Tyshchenko.
 */
public class LinkedHashSetExample {

    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();

        set.add("B");
        set.add("A");
        set.add("D");
        set.add("E");
        set.add("C");
        set.add("F");

        System.out.println("Set " + set);
    }

}
