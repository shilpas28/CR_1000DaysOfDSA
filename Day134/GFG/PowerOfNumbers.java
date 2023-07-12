//GFG
//Power Of Numbers
//Time complexity: O(logN)
//Space complexity: O(logN) 

package GFG;

public class PowerOfNumbers {

    public static void main(String[] args) {
        int N = 12;
        int R = 21;
        System.out.println(power(N, R));
    }

    static long power(int N, int R) {
        // Your code here
        int mod = 1000000007;
        if (R == 0)
            return 1;
        long ans = 0;
        if (R % 2 == 0) {
            ans = power(N, R / 2);
            ans = (ans * ans) % mod;
        }
        else {
            ans = N % mod;
            ans = (ans * power(N, R - 1) % mod) % mod;
        }
        return (ans) % mod;
    }
}
