//GFG
//Remove Duplicates
//Time complexity: O(N)
//Space complexity: O(1) 

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

    public static void main(String[] args) {
        String str = "zvvo";
        System.out.println(removeDups(str));
    }

    static String removeDups(String str) {
        // code here
        Set<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (!set.contains(c)) {
                set.add(c);
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
