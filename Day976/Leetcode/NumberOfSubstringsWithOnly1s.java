//Leetcode
//1513. Number of Substrings With Only 1s
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class NumberOfSubstringsWithOnly1s {

    public static void main(String[] args) {
        String s = "0110111";
        System.out.println(numSub(s));
    }

    public static int numSub(String s) {
        long cnt = 0, total = 0, mod = 1000000007;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                cnt++;
            } else {
                cnt = 0;
            }
            total = (total + cnt) % mod;
        }
        return (int) total;
    }
}
