//Leetcode
//950. Reveal Cards In Increasing Order - Without Using Queue 
//Time complexity: O(NlogN)
//Space complexity: O(N)

package Leetcode;

import java.util.Arrays;

public class RevealCardsInIncreasingOrder_2 {

    public static void main(String[] args) {
        int[] deck = { 17, 13, 11, 2, 3, 5, 7 };
        System.out.println(Arrays.toString(deckRevealedIncreasing(deck)));
    }

    public static int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int[] res = new int[deck.length];
        boolean[] filled = new boolean[deck.length];
        boolean skip = false;
        int i = 0, j = 0;
        while (i < deck.length) {
            if (filled[j]) {
                j = (j + 1) % deck.length;
                continue;
            }

            if (skip) {
                skip = false;
            } else {
                res[j] = deck[i++];
                filled[j] = true;
                skip = true;
            }
            j = (j + 1) % deck.length;
        }
        return res;
    }
}
