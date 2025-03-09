//Leetcode
//3208. Alternating Groups II - Expanding the Array & Sliding Window
//Time complexity: O(n+k)
//Space complexity: O(k)

public class AlternatingGroupsII {

    public static void main(String[] args) {
        int[] colors = { 0, 1, 0, 1, 0 };
        int k = 3;
        System.out.println(numberOfAlternatingGroups(colors, k));
    }

    public static int numberOfAlternatingGroups(int[] colors, int k) {
        int[] extendedColors = new int[colors.length + k - 1];
        // Extend the array to handle circular sequences
        for (int i = 0; i < colors.length; i++) {
            extendedColors[i] = colors[i];
        }
        for (int i = 0; i < k - 1; i++) {
            extendedColors[colors.length + i] = colors[i];
        }

        int length = extendedColors.length;
        int result = 0;
        // Initialize the bounds of the sliding window
        int left = 0;
        int right = 1;

        while (right < length) {
            // Check if the current color is the same as the last one
            if (extendedColors[right] == extendedColors[right - 1]) {
                // Pattern breaks, reset window from the current position
                left = right;
                right++;
                continue;
            }
            // Expand the window to the right
            right++;
            // Skip counting sequence if its length is less than k
            if (right - left < k)
                continue;
            // Record a valid sequence and shrink window from the left to search for more
            result++;
            left++;
        }
        return result;
    }
}
