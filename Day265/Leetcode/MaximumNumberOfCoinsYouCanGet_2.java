//Leetcode
//1561. Maximum Number of Coins You Can Get
//Time complexity: O(n), where n is the length of the piles array.
//Space complexity: O(max), where max is the maximum number of coins in any pile.

package Leetcode;

public class MaximumNumberOfCoinsYouCanGet_2 {

    public static void main(String[] args) {
        int[] piles = { 2, 4, 1, 2, 7, 8 };
        System.out.println(maxCoins(piles));
    }

    public static int maxCoins(int[] piles) {
        int max = 0;
        int n = piles.length;

        for (int i : piles)
            if (max < i)
                max = i;

        int[] freq = new int[max + 1];

        for (int i : piles)
            freq[i]++;

        int coins = 0;
        int chance = n / 3;
        int turn = 1;
        int i = max;

        while (chance != 0) {
            if (freq[i] > 0) {
                if (turn == 1)
                    turn = 0;
                else {
                    chance--;
                    turn = 1;
                    coins += i;
                }
                freq[i]--;
            } else {
                i--;
            }
        }
        return coins;
    }
}
