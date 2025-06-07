//GFG
//Longest Span in two Binary Arrays - Optimal
//Time complexity: O(N)
//Space complexity: O(N) 

import java.util.HashMap;

public class LongestSpanInTwoBinaryArrays_2 {

    public static void main(String[] args) {
        int a1[] = { 0, 1, 0, 0, 0, 0 };
        int a2[] = { 1, 0, 1, 0, 0, 1 };
        System.out.println(longestCommonSum(a1, a2));
    }

    public static int longestCommonSum(int[] a1, int[] a2) {
        // Code here
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < a1.length; i++) {
            sum += (a1[i] - a2[i]);
            map.put(sum, map.getOrDefault(sum, i));
            ans = Math.max(ans, i - map.get(sum));
        }
        return ans;
    }
}
