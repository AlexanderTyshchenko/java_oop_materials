package pro.tyshchenko.oop.hashtables;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author Alexander Tyshchenko.
 */
public class TreeSetExample {

    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();

        set.add("C");
        set.add("A");
        set.add("B");
        set.add("E");
        set.add("F");
        set.add("D");

        System.out.println("TreeSet " + set);
    }

}
