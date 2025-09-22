//Leetcode
//3005. Count Elements With Maximum Frequency
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

public class CountElementsWithMaximumFrequency {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 3, 1, 4 };
        System.out.println(maxFrequencyElements(nums));
    }

    public static int maxFrequencyElements(int[] nums) {
        int a[] = new int[101];
        for (int i : nums)
            a[i]++;

        int maxi = 0;
        for (int i = 0; i <= 100; i++)
            maxi = Math.max(maxi, a[i]);

        int ans = 0;
        for (int i = 0; i <= 100; i++) {
            if (a[i] == maxi)
                ans += maxi;
        }
        return ans;
    }
}
