//GFG
//Techfest and the Queue
//Time complexity: O( b*log(b) )
//Space complexity: O( b*log(b) ) 

package GFG;

import java.util.Arrays;

public class TechfestAndTheQueue_2 {

    public static void main(String[] args) {
        long a = 9, b = 12;
        System.out.println(sumOfPowers(a, b));
    }

    public static long sumOfPowers(long a, long b) {
        // code here
        if (b == 1)
            return 0;
        if (a == 1)
            a++;

        int[] prime_fact = new int[(int) (b + 1)];
        Arrays.fill(prime_fact, -1);

        for (int i = 2; i <= b; i++) {
            if (prime_fact[i] == -1) {
                for (int j = i; j <= b; j += i) {
                    prime_fact[j] = i;
                }
            }
        }

        long ans = 0;
        for (int i = (int) a; i <= b; i++) {
            int x = i;
            while (x != 1) {
                x = x / prime_fact[x];
                ans++;
            }
        }
        return ans;
    }
}
