package pro.tyshchenko.oop.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alexander Tyshchenko.
 */
public class GenericVarargsExample {

    public static void main(String[] args) {
        List<String> strings = generateList("1", "2", "3");
        System.out.println(strings);
        List<Integer> integers = generateList(1 ,2 ,3);
        System.out.println(integers);
    }

    public static <T> List<T> generateList(T ... elements) {
        List<T> list = new ArrayList<>(elements.length);
        Arrays.stream(elements).forEach((e) -> list.add(e));
        return list;
    }

}
