//Leetcode
//860. Lemonade Change
//Time complexity: O(N)
//Space complexity: O(1)

public class LemonadeChange_2 {

    class LemonadeStand {
        private int fives = 0;
        private int tens = 0;

        public boolean canProvideChange(int[] customerBills) {
            for (int bill : customerBills) {
                if (!processTransaction(bill)) {
                    return false;
                }
            }
            return true;
        }

        private boolean processTransaction(int bill) {
            switch (bill) {
                case 5:
                    fives++;
                    return true;
                case 10:
                    if (fives == 0)
                        return false;
                    fives--;
                    tens++;
                    return true;
                case 20:
                    return provideChangeFor20();
                default:
                    throw new IllegalArgumentException("Invalid bill: " + bill);
            }
        }

        private boolean provideChangeFor20() {
            if (tens > 0 && fives > 0) {
                tens--;
                fives--;
            } else if (fives >= 3) {
                fives -= 3;
            } else {
                return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        int[] bills = { 5, 5, 5, 10, 20 };
        LemonadeChange_2 obj = new LemonadeChange_2();
        System.out.println(obj.lemonadeChange(bills));
    }

    public boolean lemonadeChange(int[] bills) {
        return new LemonadeStand().canProvideChange(bills);
    }
}
