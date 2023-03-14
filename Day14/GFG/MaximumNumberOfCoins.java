//GFG - Using recursion
//Maximum Number of coins
//Time complexity: O(N^3)
//Space complexity: O(N^2)

package GFG;

import java.util.ArrayList;

public class MaximumNumberOfCoins {

    public static void main(String[] args) {
        int N = 2;
        // int a[]={5, 10};
        ArrayList<Integer> a = new ArrayList<>();
        a.add(5);
        a.add(10);
        System.out.println(maxCoins(N, a));
    }

    static int maxCoins(int N, ArrayList<Integer> arr) {
        // Write your code here
        arr.add(0, 1);
        arr.add(1);
        return solve(1, arr, N);
    }

    public static int solve(int i, ArrayList<Integer> arr, int N) {
        if (i > N)
            return 0;
        int max = Integer.MIN_VALUE;

        for (int b = i; b <= N; b++) {
            int cost = arr.get(b) * arr.get(i - 1) * arr.get(N + 1) + solve(b + 1, arr, N) + solve(i, arr, b - 1);
            max = Math.max(max, cost);
        }
        return max;
    }
}
