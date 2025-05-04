//Leetcode
//1128. Number of Equivalent Domino Pairs - Using Pair Map
//Time complexity: O(N)
//Space complexity: O(N) which is approximately O(1) as array is fexed length

package Leetcode;

public class NumberOfEquivalentDominoPairs_2 {

    public static void main(String[] args) {
        int[][] dominoes = { { 1, 2 }, { 1, 2 }, { 1, 1 }, { 1, 2 }, { 2, 2 } };
        System.out.println(numEquivDominoPairs(dominoes));
    }

    public static int numEquivDominoPairs(int[][] dominoes) {
        int[] mpp = new int[100];
        for (int[] d : dominoes)
            if (d[0] > d[1])
                mpp[d[0] * 10 + d[1]]++;
            else
                mpp[d[1] * 10 + d[0]]++;

        int count = 0;
        for (int freq : mpp)
            count += (freq - 1) * freq / 2;

        return count;
    }
}
