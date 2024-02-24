//GFG
//Maximum Sum Problem
//Time complexity: O(3^N)
//Space complexity: O(H) where H is the height of the recursive tree

package GFG;

public class MaximumSumProblem {

    public static void main(String[] args) {
        int n = 12;
        System.out.println(maxSum(n));
    }

    public static int maxSum(int n) {
        // code here.
        if (n == 0 || n == 1)
            return n;
        // recursively break the number and return
        // what maximum you can get
        return Math.max(
                (maxSum(n / 2) + maxSum(n / 3) + maxSum(n / 4)),
                n);
    }
}
