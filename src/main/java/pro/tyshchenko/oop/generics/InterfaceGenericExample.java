package pro.tyshchenko.oop.generics;

import java.util.Iterator;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author Alexander Tyshchenko.
 */
public class InterfaceGenericExample {

    public static void main(String[] args) {
        CoffeeGenerator generator = new CoffeeGenerator();
        IntStream.range(0, 5).forEach((i) -> generator.next());
        for (Coffee coffee : new CoffeeGenerator(5)) {
            System.out.println(coffee);
        }
    }

    public static class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
        private  Class[] types = {Latte.class, Mocha.class, Cappuccino.class, Americano.class, Breve.class};
        private static Random random = new Random();

        private int size = 0;

        public CoffeeGenerator() {
        }

        public CoffeeGenerator(int size) {
            this.size = size;
        }

        @Override
        public Coffee next() {
            try {
                return (Coffee)types[random.nextInt(types.length)].newInstance();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }

        @Override
        public Iterator<Coffee> iterator() {
            return new CoffeeIterator();
        }

        class CoffeeIterator implements Iterator<Coffee> {
            private int count = size;

            @Override
            public boolean hasNext() {
                return count > 0;
            }

            @Override
            public Coffee next() {
                count--;
                return CoffeeGenerator.this.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }
    }

    public interface Generator<T> {
        T next();
    }

    public static class Coffee {
        private static long counter = 0;
        private final long id = counter++;

        @Override
        public String toString() {
            return getClass().getSimpleName() + " " + id;
        }
    }

    public static class Latte extends Coffee {}
    public static class Mocha extends Coffee {}
    public static class Cappuccino extends Coffee {}
    public static class Americano extends Coffee {}
    public static class Breve extends Coffee {}


}
