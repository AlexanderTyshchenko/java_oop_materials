package pro.tyshchenko.oop.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alexander Tyshchenko.
 */
public class ArrayListExample1 {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("1");
        stringList.add("2");
        stringList.add(1, "3");
        //stringList.add(10, "3"); // IndexOutOfBoundsException

        System.out.println(stringList);

        List<String> stringList2 = Arrays.asList("4", "5", "6");

        stringList.addAll(stringList2);

        System.out.println(stringList);

        stringList.remove(1);

        System.out.println(stringList);

        System.out.println(stringList.contains("4"));
        System.out.println(stringList.contains("10"));

        System.out.println(stringList.containsAll(Arrays.asList("1", "2")));
        System.out.println(stringList.containsAll(Arrays.asList("1", "2", "100")));

    }

}
