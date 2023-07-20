//GFG
//Non Repeating Character - Using frequency array
//Time complexity: O(N)
//Space complexity: O(Number of distinct characters)

package GFG;

public class NonRepeatingCharacter {

    public static void main(String[] args) {
        String S = "hello";
        System.out.println(nonrepeatingCharacter(S));
    }

    // Function to find the first non-repeating character in a string.
    static char nonrepeatingCharacter(String S) {
        // Your code here
        int[] freq=new int[26];
        for(char ch:S.toCharArray())
        {
            freq[ch-'a']++;
        }
        for(char ch:S.toCharArray())
            if(freq[ch-'a']==1) return ch;
            return '$';
    }
}
