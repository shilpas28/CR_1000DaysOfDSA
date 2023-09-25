//Leetcode
//389. Find the Difference
//Time complexity:O(N)
//Space complexity: O(1)

package Leetcode;

public class FindTheDifference_2 {

    public static void main(String[] args) {
        String s = "abcd", t = "abcde";
        System.out.println(findTheDifference(s, t));
    }

    public static char findTheDifference(String s, String t) {
        char c = 0;
        for (char cs : s.toCharArray())
            c ^= cs;
        for (char ts : t.toCharArray())
            c ^= ts;
        return c;
    }
}
