package pro.tyshchenko.oop.threads.creation;

/**
 * @author Alexander Tyshchenko.
 */
public class CreateThreadExample_3 {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread is running");
            }
        });
//        Java 8
//        Thread thread = new Thread(() -> System.out.println("a + b = " + (a + b)));
        thread.start();
    }

}