//Leetcode
//1422. Maximum Score After Splitting a String
//Time complexity: O(N)
//Space complexity: O(1)  

package Leetcode;

public class MaximumScoreAfterSplittingAString_2 {

    public static void main(String[] args) {
        String s = "011101";
        System.out.println(maxScore(s));
    }

    public static int maxScore(String s) {
        
        int onesCount = (int) s.chars().filter(ch -> ch == '1').count();

        int result = 0;
        int zerosCount = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1') {
                onesCount--;
            } else {
                zerosCount++;
            }
            result = Math.max(result, zerosCount + onesCount);
        }
        return result;
    }
}
