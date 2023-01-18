package pro.tyshchenko.oop.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Alexander Tyshchenko.
 */
public class IteratorExample {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "2", "3");

        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

//        for (String s : list) {
//            System.out.println(s);
//        }
    }

}
