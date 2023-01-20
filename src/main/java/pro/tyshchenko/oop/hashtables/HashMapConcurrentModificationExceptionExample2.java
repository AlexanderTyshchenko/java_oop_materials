package pro.tyshchenko.oop.hashtables;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author Alexander Tyshchenko.
 */
public class HashMapConcurrentModificationExceptionExample2 {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
//        Map<Integer, String> map = new ConcurrentHashMap<>();

        ExecutorService executor = Executors.newFixedThreadPool(100);
        IntStream.range(0, 100).forEach((i) -> executor.submit(new Worker(map)));

        System.out.println(map);
    }

    private static final class Worker implements Runnable {
        private final Map<Integer, String> map;

        Random random = new Random();

        public Worker(Map<Integer, String> map) {
            this.map = map;
        }

        @Override
        public void run() {
            boolean flag = true;
            while (true) {
                if (flag) {
                    map.put(random.nextInt(100), "1");
                    flag = false;
                }
                else {
                    map.remove(random.nextInt(100));
                    flag = true;
                }

//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            }
        }
    }

}
