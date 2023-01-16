package pro.tyshchenko.oop.threads.synchronize;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author Alexander Tyshchenko.
 */
public class SynchronizedExample2 {

    public SynchronizedExample2() {
    }

    public static void main(String[] args) throws InterruptedException {
        final SynchronizedCounter counter = new SynchronizedCounter();
        int poolSize = 100;

//        List<Modifier> modifiers = new ArrayList<>(poolSize);
//
//        for (int i = 0; i < poolSize; i++) {
//            Modifier modifier = new Modifier(counter);
//            modifiers.add(modifier);
//            modifier.start();
//            modifier.join();
//        }

        ExecutorService executor = Executors.newFixedThreadPool(poolSize);
        IntStream.range(0, poolSize).forEach((x) -> executor.execute(new Modifier(counter)));

        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);


        System.out.println(counter.value());

    }


    private static final class Modifier extends Thread {

        private final SynchronizedCounter counter;

        public Modifier(SynchronizedCounter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            counter.increment();
            System.out.println(counter.value());
        }
    }

    private static final class SynchronizedCounter {
        private int count = 0;

        public synchronized void increment() {
            count++;
        }

        public synchronized void decrement() {
            count--;
        }

        public int value() {
            return count;
        }
    }

}
