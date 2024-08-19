//Leetcode
//650. 2 Keys Keyboard - Bottom Up
//Time complexity: O(N∗sqrt(N))
//Space complexity: O(N)

import java.util.Arrays;

public class TwoKeysKeyboard_3 {

    public static void main(String[] args) {
        int n = 3;
        TwoKeysKeyboard obj = new TwoKeysKeyboard();
        System.out.println(obj.minSteps(n));
    }

    public int minSteps(int n) {
        if (n == 1)
            return 0;
        int[] minOperations = new int[n + 1];
        Arrays.fill(minOperations, Integer.MAX_VALUE);
        minOperations[1] = 0;

        for (int currentCount = 2; currentCount <= n; currentCount++) {
            for (int factor = 1; factor * factor <= currentCount; factor++) {
                if (currentCount % factor == 0) {
                    minOperations[currentCount] = Math.min(minOperations[currentCount],
                            minOperations[factor] + currentCount / factor);
                    if (factor != currentCount / factor) {
                        minOperations[currentCount] = Math.min(minOperations[currentCount],
                                minOperations[currentCount / factor] + factor);
                    }
                }
            }
        }
        return minOperations[n];
    }
}
