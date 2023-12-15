//GFG
//Reach the Nth point
//Time complexity: O(N)
//Space complexity: O(N)

package GFG;

public class ReachTheNthPoint {

    public static void main(String[] args) {
        int N = 4;
        System.out.println(nthPoint(N));
    }

    public static int nthPoint(int n) {
        // Code here
        int mod = 1000000007;
        int a = 1, b = 2;
        if (n < 3)
            return n;
        for (int i = 3; i <= n; i++) {
            int temp = a;
            a = b % mod;
            b = (temp + b) % mod;
        }
        return b;
    }
}
