//Leetcode
//2220. Minimum Bit Flips to Convert Number
//Time complexity: O(logN)
//Space complexity: O(1)

public class MinimumBitFlipsToConvertNumber {

    public static void main(String[] args) {
        int start = 10, goal = 7;
        System.out.println(minBitFlips(start, goal));
    }

    public static int minBitFlips(int start, int goal) {
        int count = 0;
        while (start > 0 || goal > 0) {
            if (start % 2 != goal % 2)
                count++;
            start = start / 2;
            goal = goal / 2;
        }
        return count;
    }
}
