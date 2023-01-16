package pro.tyshchenko.oop.threads._volatile;

/**
 * @author Alexander Tyshchenko.
 */
public class VolatileExample {

    private static volatile int MY_INT = 0;

    public static void main(String[] args) {
        new ChangeListener().start();
        new ChangeMaker().start();
    }

    private static final class ChangeListener extends Thread {
        @Override
        public void run() {
            int local_value = MY_INT;
            while (local_value < 5) {
                if(local_value != MY_INT) {
                    System.out.printf("Got Change for MY_INT : %s\n", MY_INT);
                    local_value = MY_INT;
                }
            }
        }
    }

    private static final class ChangeMaker extends Thread {
        @Override
        public void run() {

            int local_value = MY_INT;
            while (MY_INT < 5) {
                System.out.printf("Incrementing MY_INT to %s\n", local_value + 1);
                MY_INT = ++local_value;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
