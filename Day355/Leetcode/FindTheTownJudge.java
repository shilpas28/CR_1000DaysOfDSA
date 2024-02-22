//Leetcode
//997. Find the Town Judge - Using 2 vector 
//Time complexity: O(E + N) E is the number of trust relationships
//Space complexity: O(2N)

package Leetcode;

public class FindTheTownJudge {

    public static void main(String[] args) {
        int n = 3;
        int[][] trust = { { 1, 3 }, { 2, 3 } };
        System.out.println(findJudge(n, trust));
    }

    public static int findJudge(int n, int[][] trust) {
        int[] trusting = new int[n + 1];
        int[] trusted = new int[n + 1];

        for (int i = 0; i < trust.length; i++) {
            trusting[trust[i][0]]++;
            trusted[trust[i][1]]++;
        }

        int ans = -1;
        for (int i = 1; i <= n; i++) {
            if (trusting[i] == 0 && trusted[i] == n - 1)
                ans = i;
        }
        return ans;
    }
}
