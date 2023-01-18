package pro.tyshchenko.oop.collections;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Alexander Tyshchenko.
 */
public class ArrayDequeExample {

    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();
        deque.push("A");
        deque.push("B");
        deque.push("C");

        while (deque.peek() != null) {
            System.out.println(deque.pop());
        }
    }

}
