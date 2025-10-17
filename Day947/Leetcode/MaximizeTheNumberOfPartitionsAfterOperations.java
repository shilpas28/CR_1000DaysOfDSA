//Leetcode
//3003. Maximize the Number of Partitions After Operations
//Time complexity: O(2^n * 26)
//Space complexity: O(m+n)

package Leetcode;

public class MaximizeTheNumberOfPartitionsAfterOperations {

    public static void main(String[] args) {
        String s = "accca";
        int k = 2;
        System.out.println(maxPartitionsAfterOperations(s, k));
    }

    public static int maxPartitionsAfterOperations(String s, int k) {
        if (k == 26)
            return 1;

        int n = s.length();
        int[] leftMask = new int[n];
        int[] leftDup = new int[n];
        int[] leftParts = new int[n];

        int mask = 0, dup = 0, parts = 1;
        for (int i = 0; i < n; i++) {
            int bit = 1 << (s.charAt(i) - 'a');
            dup |= mask & bit;
            mask |= bit;
            if (Integer.bitCount(mask) > k) {
                mask = bit;
                dup = 0;
                parts++;
            }
            leftMask[i] = mask;
            leftDup[i] = dup;
            leftParts[i] = parts;
        }

        int result = parts;
        mask = 0;
        dup = 0;
        parts = 0;

        for (int i = n - 1; i >= 0; i--) {
            int bit = 1 << (s.charAt(i) - 'a');
            dup |= mask & bit;
            mask |= bit;

            int bitCount = Integer.bitCount(mask);
            if (bitCount > k) {
                mask = bit;
                dup = 0;
                parts++;
            }

            if (bitCount == k) {
                if (((bit & dup) != 0) &&
                        ((bit & leftDup[i]) != 0) &&
                        (Integer.bitCount(leftMask[i]) == k) &&
                        ((leftMask[i] | mask) != 0x3FFFFFF)) {
                    result = Math.max(result, parts + leftParts[i] + 2);
                } else if (dup != 0) {
                    result = Math.max(result, parts + leftParts[i] + 1);
                }
            }
        }

        return result;
    }
}
