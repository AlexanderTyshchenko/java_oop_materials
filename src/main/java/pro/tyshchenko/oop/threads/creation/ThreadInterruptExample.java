package pro.tyshchenko.oop.threads.creation;

/**
 * @author Alexander Tyshchenko.
 */
public class ThreadInterruptExample {

    public static void main(String[] args) throws InterruptedException {
        CounterThread counter = new CounterThread("MyThreadCounter");
        counter.start();

        Thread.sleep(5000);
        counter.interrupt();
    }

    private static class CounterThread extends Thread {

        public CounterThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            int x = 0;

            while ( ! isInterrupted()) {
                System.out.println(getName() + " : " + x);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }
                x++;
            }
        }
    }

}