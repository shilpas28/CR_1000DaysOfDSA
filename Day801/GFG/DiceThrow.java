//GFG
//Dice throw - Space optimized DP
//Time complexity: O(m*n*x)
//Space complexity: O(x)

public class DiceThrow {

    public static void main(String[] args) {
        int m = 6, n = 3, x = 12;
        System.out.println(noOfWays(m, n, x));
    }

    static int noOfWays(int m, int n, int x) {
        // code here
        return ways(m, n, x);
    }

    static int ways(int m, int n, int x) {
        int prev[] = new int[x + 1];
        prev[0] = 1;
        for (int i = 1; i <= n; i++) {
            int curr[] = new int[x + 1];
            for (int j = 1; j <= x; j++) {
                for (int k = 1; k <= m; k++) {
                    if (j - k >= 0)
                        curr[j] += prev[j - k];
                }

            }
            prev = curr;
        }
        return prev[x];
    }
}
