package pro.tyshchenko.oop.collections;

import java.util.LinkedList;

/**
 * @author Alexander Tyshchenko.
 */
public class LinkedListExample {

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
//        List<String>  linkedList2 = new LinkedList<>();
//        Queue<String> linkedList3 = new LinkedList<>();
//        Deque<String> linkedList4 = new LinkedList<>();

        linkedList.add("F");
        linkedList.add("B");
        linkedList.add("D");
        linkedList.add("E");
        linkedList.add("C");

        linkedList.addLast("Z");
        linkedList.addFirst("A");
        linkedList.add(1, "A2");

        System.out.println("Original contents of linkedList " + linkedList);

        linkedList.remove("F");
        linkedList.remove(2);

        System.out.println("Contents of linkedList after deletion " + linkedList);

        linkedList.removeFirst();
        linkedList.removeLast();

        System.out.println("linkedList after deletion first and last " + linkedList);

        String value = linkedList.get(2);
        linkedList.set(2, value + " Changed");

        System.out.println("linkedList after changes" + linkedList);
    }

}
