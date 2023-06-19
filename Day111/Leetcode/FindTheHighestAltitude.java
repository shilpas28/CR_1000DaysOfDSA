//Leetcode
//1732. Find the Highest Altitude
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

public class FindTheHighestAltitude {

    public static void main(String[] args) {
        int[] gain = { -5, 1, 5, 0, -7 };
        System.out.println(largestAltitude(gain));
    }

    public static int largestAltitude(int[] gain) {
        int[] altitudes = new int[gain.length + 1];
        altitudes[0] = 0;
        for (int i = 1; i < altitudes.length; i++) {
            altitudes[i] = altitudes[i - 1] + gain[i - 1];
        }
        //System.out.println(Arrays.toString(altitudes));
        int maxValue = 0;
        for (int i = 0; i < altitudes.length - 1; i++) {
            if (altitudes[i + 1] > altitudes[i])
                maxValue = Math.max(altitudes[i + 1], maxValue);
        }
        return maxValue;
    }
}
