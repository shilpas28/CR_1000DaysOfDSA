//GFG
//Panagram Checking
//Time complexity:  O(|s|)
//Space complexity: O(1)

package GFG;

import java.util.HashSet;
import java.util.Set;

public class PanagramChecking_2 {

    public static void main(String[] args) {
        String s = "Bawds jog, flick quartz, vex nymph";
        System.out.println(checkPangram(s));
    }

    // Function to check if a string is Pangram or not.
    public static boolean checkPangram(String s) {
        // your code here
        Set<Character> hst = new HashSet<>();
        s = s.toLowerCase();
        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch))
                hst.add(ch);
        }
        return hst.size() == 26;
    }
}
