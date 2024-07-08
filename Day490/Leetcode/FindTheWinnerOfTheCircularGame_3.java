//Leetcode
//1823. Find the Winner of the Circular Game - Bottom-up DP with constant space
//Time complexity: O(n), since we iterate through nums [2, n]
//Space complexity: O(1), since no extra space is used

public class FindTheWinnerOfTheCircularGame_3 {

    public static void main(String[] args) {
        int n = 5, k = 2;
        System.out.println(findTheWinner(n, k));
    }

    public static int findTheWinner(int n, int k) {
        int res = 0;
        for (int player_num = 2; player_num <= n; ++player_num) {
            res = (res + k) % player_num;
        }
        return res + 1;
    }
}
