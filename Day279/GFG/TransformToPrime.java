//GFG
//Transform to prime
//Time complexity: O(N log(log N))
//Space complexity: O(1)

package GFG;

import java.util.Arrays;

public class TransformToPrime {

    public static void main(String[] args) {
        int N = 5;
        int[] arr = { 2, 4, 6, 8, 12 };
        System.out.println(minNumber(arr, N));
    }

    static boolean[] primes;
    static int MAX;

    public static int minNumber(int arr[], int N) {

        MAX = 1000001;
        primes = new boolean[MAX];
        Arrays.fill(primes, true);
        primes[1] = false;

        for (int i = 2; i * i < MAX; i++) {
            if (primes[i]) {
                for (int j = i * 2; j < MAX; j += i) {
                    primes[j] = false;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < N; i++)
            sum += arr[i];
        int st = sum;
        while (primes[st] == false)
            st++;
        return st - sum;
    }
}
