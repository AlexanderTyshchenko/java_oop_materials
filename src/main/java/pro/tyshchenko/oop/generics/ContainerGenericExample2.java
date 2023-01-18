package pro.tyshchenko.oop.generics;

/**
 * @author Alexander Tyshchenko.
 */
public class ContainerGenericExample2 {

    public static void main(String[] args) {

    }

    private static final class Container<T> {
        public final T value;

        public Container(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }
    }

}
