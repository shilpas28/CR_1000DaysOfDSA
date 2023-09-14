//GFG - solution not accpeted by GFG as TLE
//Perfect Sum Problem - using Recursion
//Time complexity: O(2^N) 
//Space complexity: O(N^2)

package GFG;

public class PerfectSumProblem {

    public static void main(String[] args) {
        int N = 6;
        int arr[] = { 2, 3, 5, 6, 8, 10 };
        int sum = 10;
        System.out.println(perfectSum(arr, N, sum));
    }

    static int mod = 1000000007;

    public static int perfectSum(int arr[], int n, int sum) {
        // Your code goes here
        return fun(0, sum, arr, n);
    }

    public static int fun(int pos, int sum, int arr[], int n) {

        if (sum < 0)
            return 0;
        if (pos == n)
            return sum == 0 ? 1 : 0;
        return (fun(pos + 1, sum, arr, n) % mod + fun(pos + 1, sum - arr[pos], arr, n) % mod) % mod;
    }

}
