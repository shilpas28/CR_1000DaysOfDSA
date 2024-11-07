//Leetcode
//2275. Largest Combination With Bitwise AND Greater Than Zero
//Time complexity: O(N * 32)
//Space complexity: O(1)

public class LargestCombinationWithBitwiseAndGreaterThanZero_2 {

    public static void main(String[] args) {
        int[] candidates = { 16, 17, 71, 62, 12, 24, 14 };
        System.out.println(largestCombination(candidates));
    }

    public static int largestCombination(int[] candidates) {
        int[] ans = new int[32];
        for (int x : candidates) 
            find(x, ans);
        
        int res = 0;
        for (int i = 0; i < 32; i++) 
            res = Math.max(res, ans[i]);
        
        return res;
    }

    public static void find(int n, int[] ans) {
        int j = 31;
        while (n > 0) {
            int a = (n & 1);
            ans[j] += a;
            n >>= 1;
            j--;
        }
    }
}
