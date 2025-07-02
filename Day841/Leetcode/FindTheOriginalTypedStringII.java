//Leetcode
//3333. Find the Original Typed String II
//Time complexity: O(n*k)
//Space complexity: O(n+k)

import java.util.ArrayList;
import java.util.List;

public class FindTheOriginalTypedStringII {

    public static void main(String[] args) {
        String word = "aabbccdd";
        int k = 7;
        System.out.println(possibleStringCount(word, k));
    }

    static final int MOD = (int) 1e9 + 7;

    public static int possibleStringCount(String word, int k) {
        if (word.isEmpty())
            return 0;

        List<Integer> groups = new ArrayList<>();
        int count = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1))
                count++;
            else {
                groups.add(count);
                count = 1;
            }
        }
        groups.add(count);

        long total = 1;
        for (int num : groups)
            total = (total * num) % MOD;

        if (k <= groups.size())
            return (int) total;

        int[] dp = new int[k];
        dp[0] = 1;
        for (int num : groups) {
            int[] newDp = new int[k];
            long sum = 0;
            for (int s = 0; s < k; s++) {
                if (s > 0)
                    sum = (sum + dp[s - 1]) % MOD;
                if (s > num)
                    sum = (sum - dp[s - num - 1] + MOD) % MOD;
                newDp[s] = (int) sum;
            }
            dp = newDp;
        }
        long invalid = 0;
        for (int s = groups.size(); s < k; s++)
            invalid = (invalid + dp[s]) % MOD;

        return (int) ((total - invalid + MOD) % MOD);
    }
}
