//Leetcode
//1128. Number of Equivalent Domino Pairs - Brute Force - Not accepted as TLE
//Time complexity: O(N^2)
//Space complexity: O(1) 

package Leetcode;

public class NumberOfEquivalentDominoPairs {

    public static void main(String[] args) {
        int[][] dominoes = { { 1, 2 }, { 1, 2 }, { 1, 1 }, { 1, 2 }, { 2, 2 } };
        System.out.println(numEquivDominoPairs(dominoes));
    }

    public static int numEquivDominoPairs(int[][] dominoes) {
        int count = 0;
        int n = dominoes.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = dominoes[i][0], b = dominoes[i][1];
                int c = dominoes[j][0], d = dominoes[j][1];
                if ((a == c && b == d) || (a == d && b == c)) {
                    count++;
                }
            }
        }
        return count;
    }
}
