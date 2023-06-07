//GFG
//Least Prime Factor
//Time complexity: O(NlogN)
//Space complexity: O(N)

package GFG;

import java.util.Arrays;

public class LeastPrimeFactor {

    public static void main(String[] args) {
        int N = 6;
        System.out.println(Arrays.toString(leastPrimeFactor(N)));
    }

    public static int[] leastPrimeFactor(int n) {
        // code here
        int[] primes = new int[n + 1];
        Arrays.fill(primes, -1);
        primes[0] = 0;
        primes[1] = 1;

        int i = 2;
        while (i <= n) {
            int j = i;
            while (j <= n) {
                if (primes[j] == -1) {
                    primes[j] = i;
                }
                j += i;
            }
            i++;
        }
        return primes;
    }
}
