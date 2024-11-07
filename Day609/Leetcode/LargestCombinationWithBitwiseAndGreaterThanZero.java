//Leetcode
//2275. Largest Combination With Bitwise AND Greater Than Zero
//Time complexity: O(N * BitMax [24])
//Space complexity: O(1)

public class LargestCombinationWithBitwiseAndGreaterThanZero {

    public static void main(String[] args) {
        int[] candidates = { 16, 17, 71, 62, 12, 24, 14 };
        System.out.println(largestCombination(candidates));
    }

    public static int largestCombination(int[] candidates) {
        final int BitMax = 24;
        int maxSet = 1;
        int mask = 1;

        for (int shift = 0; shift < BitMax; shift++) {
            int count = 0;

            for (int num : candidates) {
                if ((num & mask) != 0)
                    count++;
            }

            if (maxSet < count)
                maxSet = count;

            mask <<= 1;
        }
        return maxSet;
    }
}
