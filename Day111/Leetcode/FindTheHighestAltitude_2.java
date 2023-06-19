//Leetcode
//1732. Find the Highest Altitude
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class FindTheHighestAltitude_2 {

    public static void main(String[] args) {
        int[] gain = { -5, 1, 5, 0, -7 };
        System.out.println(largestAltitude(gain));
    }

    public static int largestAltitude(int[] gain) {
        int maxValue = 0;
        int sum = 0;
        for (int i = 0; i < gain.length; i++) {
            sum = sum + gain[i];
            maxValue = Math.max(maxValue, sum);
        }
        return maxValue;
    }
}
