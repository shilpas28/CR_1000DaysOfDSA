//Leetcode
//1611. Minimum One Bit Operations to Make Integers Zero
//Time complexity: O(log n) - The recursive approach involves dividing the problem into subproblems, and the depth of the 
//recursion is logarithmic in n.
//Space complexity: O(log n) - The space complexity is determined by the maximum depth of the recursion stack.

public class MinimumOneBitOperationsToMakeIntegersZero {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(minimumOneBitOperations(n));
    }

    public static int minimumOneBitOperations(int n) {
        if (n <= 1)
            return n;
        int count = 0;
        while ((1 << count) <= n)
            count++;
        return ((1 << count) - 1) - minimumOneBitOperations(n - (1 << (count - 1)));
    }
}
