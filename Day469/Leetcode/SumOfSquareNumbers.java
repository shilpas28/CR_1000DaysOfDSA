//Leetcode
//633. Sum of Square Numbers
//Time complexity: O(sqrt(c))
//Space complexity: O(N)

package Leetcode;

import java.util.HashSet;

public class SumOfSquareNumbers {

    public static void main(String[] args) {
        int c = 5;
        System.out.println(judgeSquareSum(c));
    }

    public static boolean judgeSquareSum(int c) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i <= Math.sqrt(c); i++) {
            set.add(i * i);
            if (set.contains(c - i * i)) {
                return true;
            }
        }
        return false;
    }
}
