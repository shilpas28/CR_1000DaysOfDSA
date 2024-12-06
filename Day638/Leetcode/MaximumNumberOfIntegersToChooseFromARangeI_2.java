//Leetcode
//2554. Maximum Number of Integers to Choose From a Range I - Binary Search
//Time complexity: O(b⋅log(b)+n⋅log(b)) (Sorting + Binary searching for every number)
//Space complexity: O(1) (No extra space required)

import java.util.Arrays;

public class MaximumNumberOfIntegersToChooseFromARangeI_2 {

    public static void main(String[] args) {
        int banned[] = { 1, 6, 5 };
        int n = 5, maxSum = 6;
        System.out.println(maxCount(banned, n, maxSum));
    }

    public static int maxCount(int[] banned, int n, int maxSum) {
        Arrays.sort(banned);
        int total = 0, count = 0;
        for (int i = 1; i <= n; i++) {
            if (!binarySearch(banned, i)) {
                total += i;
                if (total <= maxSum)
                    count++;
                else
                    break;
            }
        }
        return count;
    }

    static boolean binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target)
                return true;
            if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }
}
