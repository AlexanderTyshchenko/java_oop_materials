package pro.tyshchenko.oop.generics;

/**
 * @author Alexander Tyshchenko.
 */
public class GenericMethodExample {

    public static void main(String[] args) {
        GenericMethod.printClassName("string");
        GenericMethod.printClassName(1);
        GenericMethod.printClassName(1.2);
        GenericMethod.printClassName(1L);
        GenericMethod.printClassName('A');
    }

    private static final class GenericMethod {
        public static <T> void printClassName(T clazz) {
            System.out.println(clazz.getClass().getName());
        }
    }

}
