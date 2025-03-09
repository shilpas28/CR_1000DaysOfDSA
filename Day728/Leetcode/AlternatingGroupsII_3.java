//Leetcode
//3208. Alternating Groups II - One Pass 
//Time complexity: O(n+k)
//Space complexity: O(1)

public class AlternatingGroupsII_3 {

    public static void main(String[] args) {
        int[] colors = { 0, 1, 0, 1, 0 };
        int k = 3;
        System.out.println(numberOfAlternatingGroups(colors, k));
    }

    public static int numberOfAlternatingGroups(int[] colors, int k) {
        int length = colors.length;
        int result = 0;
        // Length of current alternating sequence
        int alternatingElementsCount = 1;
        int lastColor = colors[0];
        // Loop through array with circular traversal
        for (int i = 1; i < length + k - 1; i++) {
            int index = i % length; // Wrap around using modulo
            // Check if current color is the same as last color
            if (colors[index] == lastColor) {
                // Pattern breaks, reset sequence length
                alternatingElementsCount = 1;
                lastColor = colors[index];
                continue;
            }
            // Extend alternating sequence
            alternatingElementsCount += 1;
            // If sequence length reaches at least k, count it
            if (alternatingElementsCount >= k) {
                result++;
            }

            lastColor = colors[index];
        }
        return result;
    }
}
