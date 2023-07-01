//Leetcode
//2305. Fair Distribution of Cookies
//Time complexity: O(k^n) where n is cookies.length
//Space complexity: O(k+n) where k is cookiesDistribution array, n is number of call stacks

package Leetcode;

public class FairDistributionOfCookies {

    public static void main(String[] args) {
        int[] cookies = { 8, 15, 10, 20, 8 };
        int k = 2;
        System.out.println(distributeCookies(cookies, k));
    }

    public static int ans = Integer.MAX_VALUE;

    public static int distributeCookies(int[] cookies, int k) {
        backtracking(cookies, 0, k, new int[k]);
        return ans;
    }

    public static void backtracking(int[] cookies, int index, int k, int[] cookiesDistribution) {
        if (index == cookies.length) {
            int max = 0;
            for (int cookie : cookiesDistribution)
                max = Math.max(max, cookie);
            ans = Math.min(ans, max);
            return;
        }
        for (int i = 0; i < k; i++) {
            cookiesDistribution[i] += cookies[index];
            backtracking(cookies, index + 1, k, cookiesDistribution);
            cookiesDistribution[i] -= cookies[index];
        }
    }
}
