package pro.tyshchenko.oop.threads.deadlock;

/**
 * @author Alexander Tyshchenko.
 */
public class DeadlockExample {

    public static void main(String[] args) {
        final Friend mark = new Friend("Mark");
        final Friend tomas = new Friend("Tomas");

        new Thread(() -> mark.bow(tomas), "Thread_1").start();
        new Thread(() -> tomas.bow(mark), "Thread_2").start();
    }

    private static final class Friend {

        private final String name;

        public Friend(String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }

        public synchronized void bow(Friend bower) {
            System.out.format("%s: %s  has bowed to me!%n", this.name, bower.getName());
            bower.bowBack(this);
        }
        public synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s has bowed back to me!%n", this.name, bower.getName());
        }
    }
}
