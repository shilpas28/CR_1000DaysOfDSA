//Leetcode
//2976. Minimum Cost to Convert String I
//Time complexity: O(N^3)
//Space complexity: O(N^2) 

import java.util.Arrays;

public class MinimumCostToConvertStringI {

    public static void main(String[] args) {
        String source = "abcd", target = "acbe";
        char[] original = { 'a', 'b', 'c', 'c', 'e', 'd' };
        char[] changed = { 'b', 'c', 'b', 'e', 'b', 'e' };
        int[] cost = { 2, 5, 5, 1, 2, 20 };
        System.out.println(minimumCost(source, target, original, changed, cost));
    }

    public static long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long arr[][] = new long[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(arr[i], Integer.MAX_VALUE);
            arr[i][i] = 0;
        }
        for (int i = 0; i < original.length; i++) {
            int val1 = original[i] - 'a';
            int val2 = changed[i] - 'a';
            arr[val1][val2] = Math.min(arr[val1][val2], cost[i]);
        }
        for (int i = 0; i < 26; i++)
            for (int j = 0; j < 26; j++)
                for (int k = 0; k < 26; k++)
                    arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);

        long ans = 0;
        for (int i = 0; i < source.length(); i++) {
            int val1 = source.charAt(i) - 'a';
            int val2 = target.charAt(i) - 'a';

            if (val1 == val2)
                continue;
            if (arr[val1][val2] == Integer.MAX_VALUE)
                return -1L;
            else
                ans += arr[val1][val2];
        }
        return ans;
    }
}
