//Leetcode
//3228. Maximum Number of Operations to Move Ones to the End
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class MaximumNumberOfOperationsToMoveOnesToTheEnd {

    public static void main(String[] args) {
        String s = "1001101";
        System.out.println(maxOperations(s));
    }

    public static int maxOperations(String s) {
        int countOne = 0;
        int ans = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '0') {
                while (i + 1 < s.length() && s.charAt(i + 1) == '0') {
                    i++;
                }
                ans += countOne;
            } else {
                countOne++;
            }
            i++;
        }
        return ans;
    }
}
