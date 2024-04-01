//Leetcode
//58. Length of Last Word
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class LengthOfLastWord_2 {

    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        String str_arr[] = s.split(" ");
        int len = str_arr.length;
        return str_arr[len - 1].length();
    }
}
