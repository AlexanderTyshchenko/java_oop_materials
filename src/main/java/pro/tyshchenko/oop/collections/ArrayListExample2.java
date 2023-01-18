package pro.tyshchenko.oop.collections;

import java.util.Arrays;
import java.util.List;

/**
 * @author Alexander Tyshchenko.
 */
public class ArrayListExample2 {

    public static void main(String[] args) {
        List<Container> list = Arrays.asList(new Container(1), new Container(2), new Container(3));
        list.forEach(System.out::println);

        Container container = new Container(2);

        System.out.println(list.contains(container));
    }

    private static final class Container {
        private final int value;

        public Container(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Container{" +
                    "value=" + value +
                    '}';
        }

//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//
//            Container container = (Container) o;
//
//            return value == container.value;
//
//        }
//
//        @Override
//        public int hashCode() {
//            return value;
//        }
    }

}
