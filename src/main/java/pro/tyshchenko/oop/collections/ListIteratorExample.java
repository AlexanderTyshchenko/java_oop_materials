package pro.tyshchenko.oop.collections;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * @author Alexander Tyshchenko.
 */
public class ListIteratorExample {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "2", "3");

        ListIterator<String> listIterator = list.listIterator();

        while(listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

        System.out.println();

        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }

    }

}
