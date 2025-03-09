//Leetcode
//3208. Alternating Groups II - Two Passes
//Time complexity: O(n+k)
//Space complexity: O(1)

public class AlternatingGroupsII_2 {

    public static void main(String[] args) {
        int[] colors = { 0, 1, 0, 1, 0 };
        int k = 3;
        System.out.println(numberOfAlternatingGroups(colors, k));
    }

    public static int numberOfAlternatingGroups(int[] colors, int k) {
        int length = colors.length;
        int result = 0;
        // Tracks the length of the current alternating sequence
        int alternatingElementsCount = 1;
        int lastColor = colors[0];

        for (int index = 1; index < length; index++) {
            // Check if the current color is the same as the last one
            if (colors[index] == lastColor) {
                // Pattern breaks, reset sequence length
                alternatingElementsCount = 1;
                lastColor = colors[index];
                continue;
            }
            // Sequence can be extended
            alternatingElementsCount++;

            // Record a new alternating sequence
            if (alternatingElementsCount >= k) {
                result++;
            }

            lastColor = colors[index];
        }
        // Wrap around to the first k - 1 elements
        for (int index = 0; index < k - 1; index++) {
            // Pattern breaks. Since there are less than k elements remaining,
            // no more sequences can be formed
            if (colors[index] == lastColor)
                break;
            // Extend the pattern
            alternatingElementsCount++;
            // Record a new alternating sequence
            if (alternatingElementsCount >= k) {
                result++;
            }

            lastColor = colors[index];
        }
        return result;
    }
}
