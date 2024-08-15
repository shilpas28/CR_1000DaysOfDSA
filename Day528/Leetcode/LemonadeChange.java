//Leetcode
//860. Lemonade Change
//Time complexity: O(N)
//Space complexity: O(N) 

import java.util.Stack;

public class LemonadeChange {

    public static void main(String[] args) {
        int[] bills = { 5, 5, 5, 10, 20 };
        System.out.println(lemonadeChange(bills));
    }

    public static boolean lemonadeChange(int[] bills) {
        Stack<Integer> fives = new Stack<>();
        Stack<Integer> tens = new Stack<>();

        for (int bill : bills) {
            if (bill == 5) {
                fives.push(5);
            } else if (bill == 10) {
                if (fives.isEmpty())
                    return false;
                fives.pop();
                tens.push(10);
            } else if (bill == 20) {
                if (!tens.isEmpty() && !fives.isEmpty()) {
                    tens.pop();
                    fives.pop();
                } else if (fives.size() >= 3) {
                    fives.pop();
                    fives.pop();
                    fives.pop();
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
