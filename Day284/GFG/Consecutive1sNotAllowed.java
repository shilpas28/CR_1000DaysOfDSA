//GFG
//Consecutive 1's not allowed
//Time complexity: O(N)
//Space complexity: O(N) 

package GFG;

public class Consecutive1sNotAllowed {

    public static void main(String[] args) {
        int N = 3;
        System.out.println(countStrings(N));
    }

    static long countStrings(int n) {
        // code here
        long prev_zero = 1, prev_one = 1, curr_zero = 1, curr_one = 1, mod = (long) 1e9 + 7;
        for (int i = 2; i <= n; i++) {
            curr_zero = (prev_zero + prev_one) % mod;
            curr_one = prev_zero % mod;
            prev_zero = curr_zero;
            prev_one = curr_one;
        }
        return (curr_one + curr_zero) % mod;
    }
}
