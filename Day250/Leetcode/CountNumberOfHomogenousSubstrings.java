//Leetcode
//1759. Count Number of Homogenous Substrings
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class CountNumberOfHomogenousSubstrings {

    public static void main(String[] args) {
        String s = "abbcccaa";
        System.out.println(countHomogenous(s));
    }

    public static int countHomogenous(String s) {
        int left = 0;
        long res = 0;

        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(left) == s.charAt(right)) {
                res += right - left + 1;
            } else {
                res += 1;
                left = right;
            }
        }
        return (int) (res % (1000000007));
    }
}
