//Leetcode - using Recursion . Leetcode does not accept this as TLE
//87. Scramble String
//Time complexity: 
//Space complexity: 

package Leetcode;

public class ScrambleString {

    public static void main(String[] args) {
        String s1 = "great", s2 = "rgeat";
        System.out.println(isScramble(s1, s2));
    }

    public static boolean isScramble(String s1, String s2) {
        if (s1.equals(s2))
            return true;
        if (s1.length() <= 1)
            return false;

        boolean flag = false;

        for (int k = 1; k <= s1.length() - 1; k++) {
            boolean flag1 = isScramble(s1.substring(0, k), s2.substring(s1.length() - k)) == true
                    && isScramble(s1.substring(k), s2.substring(0, s1.length() - k)) == true;

            boolean flag2 = isScramble(s1.substring(0, k), s2.substring(0, k)) == true
                    && isScramble(s1.substring(k), s2.substring(k)) == true;
            if (flag1 || flag2)
                flag = true;
        }
        return flag;
    }

}
