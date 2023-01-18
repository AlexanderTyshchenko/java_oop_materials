package pro.tyshchenko.oop.generics;

import java.util.Arrays;
import java.util.List;

/**
 * @author Alexander Tyshchenko.
 */
public class GenericCovarianceExample {


    public static void main(String[] args) {
        new FruitContainer<Apple>(Arrays.asList(new Apple()));
    }

    interface Fruit {
        String getName();
    }

    static class Apple implements Fruit {

        @Override
        public String getName() {
            return "Apple";
        }
    }

    class Apple2 extends Apple {

    }

    static class FruitContainer<T> {


        public FruitContainer(List<? super Fruit> fruits) {
        }
    }

}
