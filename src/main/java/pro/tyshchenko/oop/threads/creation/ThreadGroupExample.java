package pro.tyshchenko.oop.threads.creation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander Tyshchenko.
 */
public class ThreadGroupExample {

    public static void main(String[] args) {
        int threadsCount = 10;
        List<CounterThread> threads = new ArrayList<>(threadsCount);

        for (int i = 0; i < threadsCount; i++) {
            CounterThread thread = new CounterThread("MyThreadCounter" + i);
            threads.add(thread);
            thread.start();
        }

        // Java 8
//        IntStream.range(1, 11).forEach(
//                (a) ->  {
//                    CounterThread thread = new CounterThread("MyThreadCounter" + a);
//                    threads.add(thread);
//                    thread.start();
//                }
//        );
//
        // Java 8
//        IntStream.range(1, threadsCount).forEach((i) -> threads.add(CounterThread.getInstance("MyThreadCounter" + i)));
//
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        for (CounterThread thread : threads) {
//            thread.interrupt();
//        }
//
//        // Java 8
//        threads.forEach(t -> t.interrupt());

        ThreadGroup threadGroup = new ThreadGroup("MyThreadGroup");

        for (int i = 0; i < 10; i++) {
            CounterThread counterThread = new CounterThread(threadGroup, "MyThreadCounter" + i);
            counterThread.start();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadGroup.interrupt();
    }

    private static final class CounterThread extends Thread {

        public CounterThread(String name) {
            super(name);
        }

        public CounterThread(ThreadGroup threadGroup, String name) {
            super(threadGroup, name);
        }

        @Override
        public void run() {
            int x = 0;

            while ( ! isInterrupted()) {
                System.out.println(getName() + " : " + x++);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }
}
