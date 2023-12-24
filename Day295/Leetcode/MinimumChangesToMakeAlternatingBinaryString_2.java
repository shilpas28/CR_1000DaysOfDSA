//Leetcode
//1758. Minimum Changes To Make Alternating Binary String
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class MinimumChangesToMakeAlternatingBinaryString_2 {

    public static void main(String[] args) {
        String s = "0100";
        System.out.println(minOperations(s));
    }

    public static int minOperations(String s) {
        int n = s.length();
        int operationsCount = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) - '0' != i % 2) {
                operationsCount++;
            }
        }
        return Math.min(operationsCount, n - operationsCount);
    }
}
