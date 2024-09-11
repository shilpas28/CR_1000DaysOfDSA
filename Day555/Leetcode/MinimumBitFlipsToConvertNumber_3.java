//Leetcode
//2220. Minimum Bit Flips to Convert Number
//Time complexity: O(1)
//Space complexity: O(1)

public class MinimumBitFlipsToConvertNumber_3 {

    public static void main(String[] args) {
        int start = 10, goal = 7;
        System.out.println(minBitFlips(start, goal));
    }

    public static int minBitFlips(int start, int goal) {
        return Integer.bitCount(start ^ goal);
    }
}
