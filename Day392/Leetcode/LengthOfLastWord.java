//Leetcode
//58. Length of Last Word
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class LengthOfLastWord {

    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        s = s.trim();
        int len = 0;
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) != ' ') {
            len++;
            i--;
        }
        return len;
    }
}
