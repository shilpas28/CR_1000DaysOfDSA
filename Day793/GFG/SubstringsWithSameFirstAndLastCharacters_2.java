//GFG
//Substrings with same first and last characters
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class SubstringsWithSameFirstAndLastCharacters_2 {

    public static void main(String[] args) {
        String s = "abcab";
        System.out.println(countSubstring(s));
    }

    public static int countSubstring(String s) {
        // code here
        int[] freq = new int[26]; // assuming only lowercase letters
        // Count frequency of each character
        for (int i = 0; i < s.length(); i++)
            freq[s.charAt(i) - 'a']++;

        int count = 0;
        // For each character, calculate valid substrings
        for (int f : freq)
            count += f * (f + 1) / 2;

        return count;
    }
}
