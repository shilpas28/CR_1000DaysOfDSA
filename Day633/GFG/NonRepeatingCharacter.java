//GFG
//Non Repeating Character
//Time complexity: O(N)
//Space complexity: O(Number of distinct characters)

package GFG;

public class NonRepeatingCharacter {

    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println(nonRepeatingChar(s));
    }

    // Function to find the first non-repeating character in a string.
    static char nonRepeatingChar(String s) {
        // Your code here
        int[] freq = new int[26];
        for (char ch : s.toCharArray())
            freq[ch - 'a']++;

        for (char ch : s.toCharArray())
            if (freq[ch - 'a'] == 1)
                return ch;
        return '$';
    }
}
