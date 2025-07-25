//GFG
//Max Circular Subarray Sum
//Time complexity: O(N)
//Space complexity: O(1) 

public class MaxCircularSubarraySum {

    public static void main(String[] args) {
        int arr[] = { 8, -8, 9, -9, 10, -11, 12 };
        System.out.println(maxCircularSum(arr));
    }

    public static int maxCircularSum(int arr[]) {
        // code here
        // either max_pos_subarray or total_sum-max_neg_subarray
        int total = 0;
        int ans_max = Integer.MIN_VALUE, cur_max = 0;
        int ans_min = Integer.MAX_VALUE, cur_min = 0;

        for (int i : arr) {
            total += i;

            cur_max = Math.max(cur_max + i, i);
            ans_max = Math.max(cur_max, ans_max);

            cur_min = Math.min(cur_min + i, i);
            ans_min = Math.min(cur_min, ans_min);
        }

        if (total == ans_min)
            return ans_max;

        return Math.max(ans_max, total - ans_min);
    }
}
