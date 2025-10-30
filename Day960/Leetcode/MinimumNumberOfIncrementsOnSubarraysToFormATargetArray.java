//Leetcode
//1526. Minimum Number of Increments on Subarrays to Form a Target Array
//Time complexity: O(N)
//Space complexity: O(1) 

public class MinimumNumberOfIncrementsOnSubarraysToFormATargetArray {

    public static void main(String[] args) {
        int[] target = { 1, 2, 3, 2, 1 };
        System.out.println(minNumberOperations(target));
    }

    public static int minNumberOperations(int[] target) {
        int n = target.length;
        int ans = target[0];
        for (int i = 1; i < n; ++i) {
            ans += Math.max(target[i] - target[i - 1], 0);
        }
        return ans;
    }
}
