//Leetcode
//2483. Minimum Penalty for a Shop
//Time complexity: O(N)
//Space complexity: O(1) 

package Leetcode;

public class MinimumPenaltyForAShop {

    public static void main(String[] args) {
        String customers = "YYNY";
        System.out.println(bestClosingTime(customers));
    }

    public static int bestClosingTime(String customers) {
        int maxScore = 0, score = 0, rightTime = -1;
        for (int i = 0; i < customers.length(); ++i) {
            score += (customers.charAt(i) == 'Y') ? 1 : -1;
            if (score > maxScore) {
                maxScore = score;
                rightTime = i;
            }
        }
        return rightTime + 1;
    }
}
