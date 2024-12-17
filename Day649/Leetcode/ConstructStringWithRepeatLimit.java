//Leetcode
//2182. Construct String With Repeat Limit - Greedy Character Frequency Distribution
//Time complexity: O(N*K)
//Space complexity: O(K)

public class ConstructStringWithRepeatLimit {

    public static void main(String[] args) {
        String s = "cczazcc";
        int repeatLimit = 3;
        System.out.println(repeatLimitedString(s, repeatLimit));
    }

    public static String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder result = new StringBuilder();
        int currentCharIndex = 25; // Start from the largest character
        while (currentCharIndex >= 0) {
            if (freq[currentCharIndex] == 0) {
                currentCharIndex--;
                continue;
            }

            int use = Math.min(freq[currentCharIndex], repeatLimit);
            for (int k = 0; k < use; k++) {
                result.append((char) ('a' + currentCharIndex));
            }
            freq[currentCharIndex] -= use;

            if (freq[currentCharIndex] > 0) { // Need to add a smaller character
                int smallerCharIndex = currentCharIndex - 1;
                while (smallerCharIndex >= 0 && freq[smallerCharIndex] == 0) {
                    smallerCharIndex--;
                }
                if (smallerCharIndex < 0) {
                    break;
                }
                result.append((char) ('a' + smallerCharIndex));
                freq[smallerCharIndex]--;
            }
        }
        return result.toString();
    }
}
