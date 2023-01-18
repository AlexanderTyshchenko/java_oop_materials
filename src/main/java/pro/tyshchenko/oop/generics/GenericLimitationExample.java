package pro.tyshchenko.oop.generics;

import java.awt.*;

/**
 * @author Alexander Tyshchenko.
 */
public class GenericLimitationExample {

    public static void main(String[] args) {
    }

    interface HasColor {
        Color getColor();
    }

    class Colored<T extends HasColor> {
        T item;

        public Colored(T item) {
            this.item = item;
        }

        public T getItem() {
            return item;
        }

        Color color() {
            return item.getColor();
        }
    }

    interface Weight {
        int getWeight();
    }

    class Dimension {
        public int x;
        public int y;
        public int z;
    }

    static class ColoredDimension<T extends Dimension & HasColor> {

    }

    class Solid<T extends Dimension & HasColor & Weight> {

    }

}
