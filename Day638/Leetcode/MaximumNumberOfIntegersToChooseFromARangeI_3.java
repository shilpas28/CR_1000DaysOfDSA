//Leetcode
//2554. Maximum Number of Integers to Choose From a Range I - TwoPointer
//Time complexity: O(b⋅log(b)+n) (Sorting + Iterating through range)
//Space complexity: O(1) (No extra space required)

import java.util.Arrays;

public class MaximumNumberOfIntegersToChooseFromARangeI_3 {

    public static void main(String[] args) {
        int banned[] = { 1, 6, 5 };
        int n = 5, maxSum = 6;
        System.out.println(maxCount(banned, n, maxSum));
    }

    public static int maxCount(int[] banned, int n, int maxSum) {
        Arrays.sort(banned);
        int total = 0, count = 0, it = 0;
        for (int i = 1; i <= n; i++) {
            if (it < banned.length && banned[it] == i) {
                while (it < banned.length && banned[it] == i) {
                    it++;
                }
            } else {
                total += i;
                if (total <= maxSum)
                    count++;
                else
                    break;
            }
        }
        return count;
    }
}
