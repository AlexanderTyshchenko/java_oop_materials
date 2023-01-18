package pro.tyshchenko.oop.generics;

import com.tyshchenko.training.java.oop.lesson9.generics.InterfaceGenericExample.Coffee;
import com.tyshchenko.training.java.oop.lesson9.generics.InterfaceGenericExample.Generator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.IntStream;

import static com.tyshchenko.training.java.oop.lesson9.generics.InterfaceGenericExample.*;

/**
 * @author Alexander Tyshchenko.
 */
public class GenericGeneratorExample {

    public static void main(String[] args) {
        Collection<Coffee> coffees = Generators.fill(new ArrayList<>(), new CoffeeGenerator(), 5);
        System.out.println(coffees);
    }

    private static final class Generators {
        public static <T> Collection<T> fill(Collection<T> collection, Generator<T> generator, int length) {
            IntStream.range(0, length).forEach((i) -> collection.add(generator.next()));
            return collection;
        }
    }

}
