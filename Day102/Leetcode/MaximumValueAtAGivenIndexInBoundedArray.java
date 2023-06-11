//Leetcode
//1802. Maximum Value at a Given Index in a Bounded Array
//Time complexity: O(logN) 
//Space complexity: O(1)

package Leetcode;

public class MaximumValueAtAGivenIndexInBoundedArray {

    public static void main(String[] args) {
        int n = 4, index = 2, maxSum = 6;
        System.out.println(maxValue(n, index, maxSum));
    }

    public static int maxValue(int n, int index, int maxSum) {
        int emptyR = n - index - 1;
        int emptyL = index;
        int h = maxSum, l = 1;
        int res = 0;
        while (l <= h) {
            int mid = (h - l) / 2 + l;
            long leftSum = 0, rightSum = 0, el = mid - 1;
            if (emptyR <= el)

                rightSum = (el * (el + 1)) / 2 - ((el - emptyR) * (el - emptyR + 1)) / 2;
            else
                rightSum = (el * (el + 1)) / 2 + (emptyR - el);
            if (emptyL <= el)
                leftSum = (el * (el + 1)) / 2 - ((el - emptyL) * (el - emptyL + 1)) / 2;
            else
                leftSum = (el * (el + 1)) / 2 + (emptyL - el);
            long sum = leftSum + mid + rightSum;
            if (sum <= maxSum) {
                l = mid + 1;
                res = mid;
            } else {
                h = mid - 1;
            }
        }
        return res;
    }
}
