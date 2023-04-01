//GFG - Optimal solution (using Median)
//Make Array Elements Equal
//Time complexity: O(1)
//Space complexity: O(1)

package GFG;

public class MakeArrayElementsEqual_2 {
    public static void main(String[] args) {
        int N = 3;
        System.out.println(minOperations(N));
    }

    public static long minOperations(int N) {
        // Code here
        long mid = N / 2;
        return N % 2 == 0 ? (long) mid * (long) mid : (long) mid * (long) (mid + 1);
    }
}
