//GFG
//Panagram Checking
//Time complexity:  O(|s|)
//Space complexity: O(1)

package GFG;

public class PanagramChecking {

    public static void main(String[] args) {
        String s = "Bawds jog, flick quartz, vex nymph";
        System.out.println(checkPangram(s));
    }

    // Function to check if a string is Pangram or not.
    public static boolean checkPangram(String s) {
        // your code here
        if (s.length() < 26)
            return false;
        char id = 'a';
        for (int i = 0; i < 26; i++) {
            if (s.contains(Character.toString(id)) || s.contains(Character.toString(id).toUpperCase())) {
                id++;
            } else {
                return false;
            }
        }
        return true;
    }
}
