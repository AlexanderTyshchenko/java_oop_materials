package pro.tyshchenko.oop.threads.creation;

/**
 * @author Alexander Tyshchenko.
 */
public class ThreadDaemonExample {

    public static void main(String[] args) {
        DaemonThread thread = new DaemonThread();
        thread.setDaemon(true);
        thread.start();

        System.out.println("Finishing main");
    }

    private static class DaemonThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {

            }
            System.out.println("Thread work is finished");
        }
    }

}