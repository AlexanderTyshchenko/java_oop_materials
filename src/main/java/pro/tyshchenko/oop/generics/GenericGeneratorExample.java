package pro.tyshchenko.oop.generics;

import pro.tyshchenko.oop.generics.InterfaceGenericExample.Coffee;
import pro.tyshchenko.oop.generics.InterfaceGenericExample.Generator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.IntStream;

import static pro.tyshchenko.oop.generics.InterfaceGenericExample.*;

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
