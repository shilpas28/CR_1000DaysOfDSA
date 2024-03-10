//GFG
//Remove all duplicates from a given string
//Time complexity: O(N)
//Space complexity: O(N) or O(256)

package GFG;

import java.util.HashMap;

public class RemoveAllDuplicatesFromAGivenString {

    public static void main(String[] args) {
        String str = "geEksforGEeks";
        System.out.println(removeDuplicates(str));
    }

    static String removeDuplicates(String str) {
        StringBuilder ans = new StringBuilder();
        HashMap<Character, Integer> mm = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (mm.get(str.charAt(i)) == null) {
                ans.append(str.charAt(i));
                mm.put(str.charAt(i), 1);
            }
        }
        return ans.toString();
    }
}
