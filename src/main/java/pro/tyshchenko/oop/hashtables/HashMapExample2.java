package pro.tyshchenko.oop.hashtables;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alexander Tyshchenko.
 */
public class HashMapExample2 {

    public static void main(String[] args) {
        Map<Account, List<Order>> accounts = new HashMap<>();

        Account account1 = new Account(1, new BigDecimal("1000"));
        Account account2 = new Account(2, new BigDecimal("10000"));
        Account account3 = new Account(1, new BigDecimal("1000"));

        accounts.put(account1, Collections.EMPTY_LIST);
        accounts.put(account2, Collections.EMPTY_LIST);
        accounts.put(account3, Collections.EMPTY_LIST);

        accounts.forEach((k, v) -> System.out.println("Key=" + k + " Value" + v));

        Map<Long, List<Order>> accounts2 = new HashMap<>();
        Account account4 = new Account(3, new BigDecimal("1000"));

        accounts2.put(account1.getAccountID(), Collections.EMPTY_LIST);
        accounts2.put(account2.getAccountID(), Collections.EMPTY_LIST);
        accounts2.put(account3.getAccountID(), Collections.EMPTY_LIST);
        accounts2.put(account4.getAccountID(), Arrays.asList(new Order(10227349857L)));

        accounts2.forEach((k, v) -> System.out.println("Key=" + k + " Value" + v));
    }

    private static final class Account {
        private final long accountID;
        private BigDecimal amount;

        public Account(long accountID, BigDecimal amount) {
            this.accountID = accountID;
            this.amount = amount;
        }

        public long getAccountID() {
            return accountID;
        }

//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//
//            Account account = (Account) o;
//
//            if (accountID != account.accountID) return false;
//            return !(amount != null ? !amount.equals(account.amount) : account.amount != null);
//
//        }
//
//        @Override
//        public int hashCode() {
//            int result = (int) (accountID ^ (accountID >>> 32));
//            result = 31 * result + (amount != null ? amount.hashCode() : 0);
//            return result;
//        }

        @Override
        public String toString() {
            return "Account{" +
                    "accountID=" + accountID +
                    ", amount=" + amount +
                    '}';
        }
    }

    private static final class Order {
        private final long orderId;

        public Order(long orderId) {
            this.orderId = orderId;
        }

        @Override
        public String toString() {
            return "Order{" +
                    "orderId=" + orderId +
                    '}';
        }
    }

}
