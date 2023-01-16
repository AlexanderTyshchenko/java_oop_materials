package pro.tyshchenko.oop.threads.synchronize;

/**
 * @author Alexander Tyshchenko.
 */
public class SynchronizedExample1 {

    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(1000_000);
        int size = 10000;
        Action[] actions = new Action[size];

        for (int i = 0; i < size; i++) {
            actions[i] = new Action(account, 100);
        }

        for (int i = 0; i < size; i++) {
            actions[i].start();
        }

        for (int i = 0; i < size; i++) {
            actions[i].join();
        }

        System.out.println(account.getAmount());
    }


    private static final class Action extends Thread {

        private final Account account;
        private final int withdraw;

        public Action(Account account, int withdraw) {
            this.account = account;
            this.withdraw = withdraw;
        }

        public void run() {
            synchronized (account) {
                int amount = account.getAmount();
                if (amount >= withdraw) {
                    account.setAmount(account.getAmount() - withdraw);
                }
            }
        }
    }

    private static final class Account {

        private int amount;

        public Account(int amount) {
            this.amount = amount;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }
    }

}
