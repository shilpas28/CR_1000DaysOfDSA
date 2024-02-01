//GFG
//Panagram Checking
//Time complexity:  O(|s|)
//Space complexity: O(1)

package GFG;

public class PanagramChecking_3 {

    public static void main(String[] args) {
        String s = "Bawds jog, flick quartz, vex nymph";
        System.out.println(checkPangram(s));
    }

    // Function to check if a string is Pangram or not.
    public static boolean checkPangram(String s) {
        // your code here
        Boolean[] mark = new Boolean[26];
        for (int i = 0; i < 26; i++)
            mark[i] = false;

        // iterating over the string
        for (int i = 0; i < s.length(); i++) {
            // marking index of current character as true in hash table

            // if we get uppercase character, we subtract 'A' from it
            // to get its index (in terms of 0 to 25).
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
                mark[s.charAt(i) - 'A'] = true;

            // if we get lowercase character, we subtract 'a' from it
            // to get its index (in terms of 0 to 25).
            else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
                mark[s.charAt(i) - 'a'] = true;
        }
        // returning false if any letter of alphabet is unmarked.
        for (int i = 0; i < 26; i++)
            if (!mark[i])
                return false;

        // if all letters of alphabet are present then returning true.
        return true;
    }
}
