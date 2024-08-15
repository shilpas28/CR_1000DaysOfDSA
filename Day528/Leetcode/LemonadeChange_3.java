//Leetcode
//860. Lemonade Change
//Time complexity: O(N)
//Space complexity: O(1)

public class LemonadeChange_3 {

    public static void main(String[] args) {
        int[] bills = { 5, 5, 5, 10, 20 };
        System.out.println(lemonadeChange(bills));
    }

    public static boolean lemonadeChange(int[] bills) {
        int state = 0;
        for (int bill : bills) {
            if (bill == 5) {
                state++;
            } else if (bill == 10) {
                if ((state & 0xFFFF) == 0)
                    return false;
                state--;
                state += 0x10000;
            } else { // bill == 20
                if ((state & 0xFFFF0000) != 0 && (state & 0xFFFF) != 0) {
                    state -= 0x10001;
                } else if ((state & 0xFFFF) >= 3) {
                    state -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
