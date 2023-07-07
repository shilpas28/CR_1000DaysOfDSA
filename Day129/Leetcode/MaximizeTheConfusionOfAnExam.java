//Leetcode
//2024. Maximize the Confusion of an Exam
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class MaximizeTheConfusionOfAnExam {

    public static void main(String[] args) {
        String answerKey = "TTFF";
        int k = 2;
        System.out.println(maxConsecutiveAnswers(answerKey, k));
    }

    public static int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(solve(answerKey, k, 'T'), solve(answerKey, k, 'F'));
    }

    public static int solve(String answerKey, int k, char ch) {
        int i = 0, j = 0, cnt = 0, res = 0;
        while (j < answerKey.length()) {
            if (answerKey.charAt(j) == ch)
                cnt++;
            while (cnt > k) {
                if (answerKey.charAt(i) == ch)
                    cnt--;
                i++;
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }
}
