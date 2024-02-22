//Leetcode
//997. Find the Town Judge - Using single vector
//Time complexity: O(E + N) E is the number of trust relationships
//Space complexity: O(N) 

package Leetcode;

public class FindTheTownJudge_2 {

    public static void main(String[] args) {
        int n = 3;
        int[][] trust = { { 1, 3 }, { 2, 3 } };
        System.out.println(findJudge(n, trust));
    }

    public static int findJudge(int n, int[][] trust) {
        int[] trustcount = new int[n + 1];

        for (int[] relation : trust) {
            trustcount[relation[0]]--;
            trustcount[relation[1]]++;
        }

        for (int i = 1; i <= n; ++i) {
            if (trustcount[i] == n - 1) {
                return i;
            }
        }
        return -1; // no judge found
    }
}
