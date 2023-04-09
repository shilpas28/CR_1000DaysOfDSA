//GFG
//Special Digits
//Time complexity: O(NlogN)
//Space complexity: O(N)

public class SpecialDigits {

    public static void main(String[] args) {
        int N = 2, A = 1, B = 2, C = 3, D = 5;
        System.out.println(bestNumbers(N, A, B, C, D));
    }

    static int N = (int) 1e5 + 5;
    static int M = (int) 1e9 + 7;

    static long binpow(long a, long b, long p) {
        if (b == 0)
            return 1;
        long t = binpow(a, b / 2, p);
        if (b % 2 != 0)
            return (((a * t) % p) * t) % p;
        else
            return ((t * t) % p);
    }

    static long[] fact;
    static long[] invfact;

    static void init() {
        fact[0] = 1;
        for (int i = 1; i < N; i++) {
            fact[i] = i * fact[i - 1] % M;
        }
        invfact[N - 1] = binpow(fact[N - 1], M - 2, M);
        for (int i = N - 2; i >= 0; i--) {
            invfact[i] = (i + 1) * invfact[i + 1] % M;
        }
    }

    static long ncr(int n, int r, long p) {
        return (((fact[n] * invfact[n - r]) % p) * invfact[r]) % p;
    }

    static boolean f;

    public static int bestNumbers(int N, int A, int B, int C, int D) {
        // code here
        fact = new long[N];
        invfact = new long[N];
        f = false;
        if (!f) {
            f = true;
            init();
        }
        long ans = 0;
        if (A == B) {
            long sum = 1L * N * A;
            while (sum > 0) {
                if (sum % 10 == C || sum % 10 == D) {
                    return 1;
                }
                sum /= 10;
            }
            return 0;
        } else {
            for (int i = 0; i <= N; i++) {
                int sum = i * A + (N - i) * B;
                boolean good = false;
                while (sum > 0) {
                    if (sum % 10 == C || sum % 10 == D) {
                        good = true;
                        break;
                    }
                    sum /= 10;
                }
                if (good) {
                    ans += ncr(N, i, M);
                    ans %= M;
                }
            }
            return (int) ans;
        }
    }

}
