//GFG
//Chocolate Distribution Problem
//Time complexity: O(N*Log(N))
//Space complexity: O(1) 

package GFG;

import java.util.ArrayList;
import java.util.Collections;

public class ChocolateDistributionProblem {

    public static void main(String[] args) {
        int N = 8, M = 5;
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(3);
        A.add(4);
        A.add(1);
        A.add(9);
        A.add(56);
        A.add(7);
        A.add(9);
        A.add(12);
        System.out.println(findMinDiff(A, N, M));
    }

    public static long findMinDiff(ArrayList<Integer> a, int n, int m) {
        // your code here
        Collections.sort(a);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i + m - 1 < n; i++)
            ans = Math.min(ans, a.get(i + m - 1) - a.get(i));
        return ans;
    }
}
