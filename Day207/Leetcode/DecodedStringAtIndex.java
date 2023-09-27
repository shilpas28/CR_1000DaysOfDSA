//Leetcode
//880. Decoded String at Index
//Time complexity: O(N)
//Space complexity: O(1) 

package Leetcode;

public class DecodedStringAtIndex {

    public static void main(String[] args) {
        String s = "leet2code3";
        int k = 10;
        System.out.println(decodeAtIndex(s, k));
    }

    public static String decodeAtIndex(String s, int k) {
        int i;
        long N = 0;
        for (i = 0; N < k; i++) {
            N = Character.isDigit(s.charAt(i)) ? N * (s.charAt(i) - '0') : N + 1;
        }
        for (i--; i > 0; i--) {
            if (Character.isDigit(s.charAt(i))) {
                N /= s.charAt(i) - '0';
                k %= N;
            } else {
                if (k % N == 0) {
                    break;
                }
                N--;
            }
        }
        return Character.toString(s.charAt(i));
    }
}
