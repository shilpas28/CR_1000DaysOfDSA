//Leetcode
//205. Isomorphic Strings - Using Character Arrays
//Time complexity: O(length(s) + length(t))
//Space complexity: O(number of different characters)

package Leetcode;

public class IsomorphicStrings_2 {

    public static void main(String[] args) {
        String s = "egg", t = "add";
        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;

        char sToT[] = new char[256];
        char tToS[] = new char[256];

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (sToT[sChar] == 0 && tToS[tChar] == 0) {
                sToT[sChar] = tChar;
                tToS[tChar] = sChar;
            } else if (sToT[sChar] != tChar)
                return false;
        }
        return true;
    }
}
