package pro.tyshchenko.oop.threads.creation;

/**
 * @author Alexander Tyshchenko.
 */
public class CreateThreadExample_2 {

    public static void main(String[] args) {
        String name = "MyThread";
        Thread thread = new Thread(new MyThread(name), name);
        thread.start();
    }

    private static class MyThread implements Runnable {

        private final String name;

        public MyThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("Thread " + name + " is running");
        }
    }
}
