//Leetcode
//2043. Simple Bank System
//Time complexity: O(1)
//Space complexity: O(1)

public class SimpleBankSystem {

    static class Bank {

        private final long[] bal;
        private final int n;

        public Bank(long[] balance) {
            this.bal = balance;
            this.n = bal.length;
        }

        public boolean transfer(int from, int to, long amt) {
            if (!valid(from) || !valid(to) || bal[from - 1] < amt)
                return false;
            bal[from - 1] -= amt;
            bal[to - 1] += amt;
            return true;
        }

        public boolean deposit(int acc, long amt) {
            if (!valid(acc))
                return false;
            bal[acc - 1] += amt;
            return true;
        }

        public boolean withdraw(int acc, long amt) {
            if (!valid(acc) || bal[acc - 1] < amt)
                return false;
            bal[acc - 1] -= amt;
            return true;
        }

        private boolean valid(int acc) {
            return acc > 0 && acc <= n;
        }
    }

    public static void main(String[] args) {
        long[] vals = { 10, 100, 20, 50, 30 };
        Bank bank = new Bank(vals);
        System.out.println(bank.withdraw(3, 10)); // return true, account 3 has a balance of $20, so it is valid to withdraw $10.
                              // Account 3 has $20 - $10 = $10.
        System.out.println(bank.transfer(5, 1, 20)); // return true, account 5 has a balance of $30, so it is valid to transfer $20.
                                 // Account 5 has $30 - $20 = $10, and account 1 has $10 + $20 = $30.
        System.out.println(bank.deposit(5, 20)); // return true, it is valid to deposit $20 to account 5.
                             // Account 5 has $10 + $20 = $30.
        System.out.println(bank.transfer(3, 4, 15)); // return false, the current balance of account 3 is $10,
                                 // so it is invalid to transfer $15 from it.
        System.out.println(bank.withdraw(10, 50)); // return false, it is invalid because account 10 does not exist.
    }
}
