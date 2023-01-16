package pro.tyshchenko.oop.threads.creation;

/**
 * @author Alexander Tyshchenko.
 */
public class ThreadStateExample {

    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread("MyThread");
        System.out.println("Thread state is " + thread.getState());
        thread.start();
        thread.join();
        System.out.println("Thread state is " + thread.getState());
    }

    private static class MyThread extends Thread {

        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println("Thread " + getName() + " is running");
            System.out.println("Thread id is " + getId());
            System.out.println("Thread priority is " + getPriority());
            System.out.println("Thread state is " + getState());
            System.out.println("Thread group is " + getThreadGroup());
        }
    }
}
