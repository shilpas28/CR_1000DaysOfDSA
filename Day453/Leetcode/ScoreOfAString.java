//Leetcode
//3110. Score of a String
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class ScoreOfAString {

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(scoreOfString(s));
    }

    public static int scoreOfString(String s) {
        int[] array = new int[s.length()];
        int ans = 0, index = 0;
        for (char ch : s.toCharArray()) {
            array[index++] = (int) ch;
        }
        for (int i = 1; i < s.length(); i++) {
            ans += Math.abs(array[i - 1] - array[i]);
        }
        return ans;
    }
}
