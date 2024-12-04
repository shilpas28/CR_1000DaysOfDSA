//GFG
//Strings Rotations of Each Other - Not accepted as TLE 
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.Arrays;

public class StringsRotationsOfEachOther {

    public static void main(String[] args) {
        String s1 = "abcd", s2 = "cdab";
        System.out.println(areRotations(s1, s2));
    }

    // Function to check if two strings are rotations of each other or not.
    public static boolean areRotations(String s1, String s2) {
        // Your code here
        StringBuilder temp = new StringBuilder(s2);
        temp.append('$').append(s1).append(s1);
        int n = temp.length(), i = 0, j = 1, m = s2.length();
        int lps[] = new int[n];
        Arrays.fill(lps, 0);
        String str = temp.toString();
        while (j < n) {
            if (str.charAt(i) == str.charAt(j)) {
                lps[j++] = ++i;
                if (i == m)
                    return true;
            } else if (i != 0)
                i = lps[i - 1];
            else
                j++;
        }
        return false;
    }
}
