package pro.tyshchenko.oop.threads.creation;

/**
 * @author Alexander Tyshchenko.
 */
public class ThreadJoinExample {

    public static void main(String[] args) {
        MyCounter counter1 = new MyCounter("counter_1");
        MyCounter counter2 = new MyCounter("counter_2");
        counter1.start();
        counter2.start();

        try {
            counter1.join();
            counter2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("End main thread");
    }

    private static final class MyCounter extends Thread {

        private String name;

        public MyCounter(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            int x = 1;
            while (x < 10) {
                x++;
                System.out.println(name + " -> " + x);
            }
            System.out.println("MyCounter thread finished");
        }
    }

}
