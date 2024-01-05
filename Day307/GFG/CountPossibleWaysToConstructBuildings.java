//GFG
//Count possible ways to construct buildings
//Time complexity: O(N)
//Space complexity: O(N)

package GFG;

public class CountPossibleWaysToConstructBuildings {

    public static void main(String[] args) {
        int N = 3;
        System.out.println(TotalWays(N));
    }

    public static int TotalWays(int N) {
        // Code here
        if (N == 1) {
            return 4;
        }
        if (N == 2) {
            return 9;
        }
        long mod = 1000000007;
        long previous_two = 2, previous_one = 3, present = 0;
        for (int i = 3; i <= N; i++) {
            present = (previous_one + previous_two + mod) % mod;
            previous_two = previous_one;
            previous_one = present;
        }
        long total = ((present % mod) * (present % mod)) % mod;
        return (int) total;
    }
}
