//GFG
//Two Sum - Pair with Given Sum
//Time complexity: O(NlogN)
//Space complexity: O(N) 

import java.util.Arrays;

public class TwoSumPairWithGivenSum {

    public static void main(String[] args) {
        int arr[] = { 1, 4, 45, 6, 10, 8 };
        int target = 16;
        System.out.println(twoSum(arr, target));
    }

    static boolean twoSum(int arr[], int target) {
        // code here
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            if ((arr[i] + arr[j]) == target)
                return true;
            else if ((arr[i] + arr[j]) < target)
                i++;
            else
                j--;
        }
        return false;
    }
}
