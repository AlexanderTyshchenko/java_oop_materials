package pro.tyshchenko.oop.threads.creation;

/**
 * @author Alexander Tyshchenko.
 */
public class CreateThreadExample_1 {

    public static void main(String[] args) {
        MyThread thread = new MyThread("MyThread");
        thread.start();
    }

    private static class MyThread extends Thread {

        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println("Thread " + getName() + " is running");
        }
    }
}
