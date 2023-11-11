//GFG
//Isomorphic Strings
//Time complexity: O(|str1|+|str2|)
//Space complexity: O(Number of different characters)

import java.util.HashMap;

public class IsomorphicStrings {

    public static void main(String[] args) {
        String str1 = "aab";
        String str2 = "xxy";
        System.out.println(areIsomorphic(str1, str2));
    }

    // Function to check if two strings are isomorphic.
    public static boolean areIsomorphic(String str1, String str2) {
        // Your code here
        int n1 = str1.length(), n2 = str2.length();
        if (n1 != n2)
            return false;

        HashMap<Character, Character> map = new HashMap<>(); // store mapping of s1 to s2
        HashMap<Character, Integer> vis = new HashMap<>(); // for s2

        for (int i = 0; i < n1; i++) {
            char c1 = str1.charAt(i), c2 = str2.charAt(i);
            if (!map.containsKey(c1)) {
                // c1 seen for the first time
                if (!vis.containsKey(c2)) {
                    // c2 also seen for the first time, map c1->c2 and mark c2 vis.
                    map.put(c1, c2);
                    vis.put(c2, 1);
                }
                // c1 is seen for first time , but c2 is already mapped somewhere.
                else if (vis.get(c2) == 1)
                    return false;
            }
            // c1 already mapped, but not to c2
            else if (map.get(c1) != c2)
                return false;
        }
        return true;
    }
}
