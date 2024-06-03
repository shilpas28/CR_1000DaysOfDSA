//GFG 
//Trail of ones
//Time complexity: O(N)
//Space complexity: O(1)

public class TrailOfOnes {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(numberOfConsecutiveOnes(n));
    }

    static int numberOfConsecutiveOnes(int n) {
        // code here
        if (n == 2)
            return 1;
        int ans = 1, a = 0, b = 1, mod = 1000000007;
        for (int i = 3; i <= n; i++) {
            int c = (a + b) % mod;
            a = b;
            b = c;
            ans = ((ans * 2) % mod + c) % mod;
        }
        return ans;
    }
}
