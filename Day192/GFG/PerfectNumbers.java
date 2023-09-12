//GFG
//Perfect Numbers
//Time complexity: O(sqrt(N))
//Space complexity: O(1) 

package GFG;

public class PerfectNumbers {

    public static void main(String[] args) {
        long N = 6;
        System.out.println(isPerfectNumber(N));
    }

    static int isPerfectNumber(long N) {
        // code here
        if (N == 1)
            return 0;

        long sum = 1;
        for (long i = 2; i * i <= N; i++) {
            if (N % i == 0)
                sum = sum + i + N / i;
        }
        if (sum == N)
            return 1;

        return 0;
    }
}
