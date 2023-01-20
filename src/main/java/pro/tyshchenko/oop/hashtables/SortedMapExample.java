package pro.tyshchenko.oop.hashtables;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author Alexander Tyshchenko.
 */
public class SortedMapExample {

    public static void main(String[] args) {
//        SortedMap<Account, List<Order>> map = new TreeMap<>();
        SortedMap<Account, List<Order>> map = new TreeMap<>(new AccountDescendingComparator());

        Account account1 = new Account(1);
        Account account2 = new Account(2);
        Account account3 = new Account(3);
        Account account4 = new Account(4);
        Account account5 = new Account(5);
        Account account6 = new Account(6);

        map.put(account1, Collections.EMPTY_LIST);
        map.put(account3, Collections.EMPTY_LIST);
        map.put(account6, Collections.EMPTY_LIST);
        map.put(account2, Collections.EMPTY_LIST);
        map.put(account5, Collections.EMPTY_LIST);
        map.put(account4, Collections.EMPTY_LIST);

        map.forEach((k, v) -> System.out.println("Key=" + k + " Value=" + v));

        System.out.println();
        SortedMap<Account, List<Order>> headMap = map.headMap(account4);

        headMap.forEach((k, v) -> System.out.println("Key=" + k + " Value=" + v));

        SortedMap<Account, List<Order>> subMap = map.subMap(account2, account4);

        System.out.println();
        subMap.forEach((k, v) -> System.out.println("Key=" + k + " Value=" + v));
    }

    private static final class Account {
        private final long accountId;

        public Account(long accountId) {
            this.accountId = accountId;
        }

        public long getAccountId() {
            return accountId;
        }

        @Override
        public String toString() {
            return "Account{" +
                    "accountId=" + accountId +
                    '}';
        }
    }

    private static final class Order {}

    private static final class AccountDescendingComparator implements Comparator<Account> {

        @Override
        public int compare(Account o1, Account o2) {
            if (o1.accountId == o2.accountId) {
                return 0;
            }
            else if(o1.accountId > o2.accountId) {
                return 1;
            }
            else {
                return -1;
            }
        }
    }

}
