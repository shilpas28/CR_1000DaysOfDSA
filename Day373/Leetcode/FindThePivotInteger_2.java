//Leetcode
//2485. Find the Pivot Integer - Binary Search
//Time complexity: O(logN)
//Space complexity: O(1)

package Leetcode;

public class FindThePivotInteger_2 {

    public static void main(String[] args) {
        int n = 8;
        System.out.println(pivotInteger(n));
    }

    public static int pivotInteger(int n) {
        int sum = n * (n + 1) / 2;
        int lo = 1, hi = n + 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int leftSum = (mid - 1) * mid / 2;
            int rightSum = sum - (mid + 1) * mid / 2;
            if (leftSum < rightSum) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return (lo - 1) * lo / 2 == sum - lo * (lo + 1) / 2 ? lo : -1;
    }
}
