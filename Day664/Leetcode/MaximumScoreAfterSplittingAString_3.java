//Leetcode
//1422. Maximum Score After Splitting a String
//Time complexity: O(N)
//Space complexity: O(1)  

public class MaximumScoreAfterSplittingAString_3 {

    public static void main(String[] args) {
        String s = "00111";
        System.out.println(maxScore(s));
    }

    public static int maxScore(String s) {
        int onesCount = 0;
        int zerosCount = 0;
        int bestScore = Integer.MIN_VALUE;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1') {
                onesCount++;
            } else {
                zerosCount++;
            }
            bestScore = Math.max(bestScore, zerosCount - onesCount);
        }
        if (s.charAt(s.length() - 1) == '1') {
            onesCount++;
        }
        return bestScore + onesCount;
    }
}
