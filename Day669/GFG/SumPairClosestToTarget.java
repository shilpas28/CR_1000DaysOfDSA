//GFG
//Sum Pair closest to target
//Time complexity: O(NlogN)
//Space complexity: O(1)

package GFG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumPairClosestToTarget {

    public static void main(String[] args) {
        int arr[] = { 10, 30, 20, 5 };
        int target = 25;
        System.out.println(sumClosest(arr, target));
    }

    public static List<Integer> sumClosest(int[] arr, int target) {
        // code here
        Arrays.sort(arr);
        List<Integer> ans = new ArrayList<>();
        int st = 0, end = arr.length - 1, currClose = Integer.MAX_VALUE;
        while (st < end) {
            int sum = arr[st] + arr[end];
            if (Math.abs(target - sum) < currClose) {
                currClose = Math.abs(target - sum);
                ans.clear();
                ans.add(arr[st]);
                ans.add(arr[end]);
            }
            if (sum < target) {
                st++;
            } else if (sum > target) {
                end--;
            } else {
                return ans;
            }
        }
        return ans;
    }
}
