//Leetcode
//1925. Count Square Sum Triples
//Time complexity: O(N)
//Space complexity: O(1)

public class CountSquareSumTriples_2 {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(countTriples(n));
    }

    public static int countTriples(int n) {
        int cnt = 0;
        // Iterate m starting from 2
        for (int m = 2; m * m < n; m++) {
            // Iterate k from 1 to m
            for (int k = 1; k < m; k++) {
                // Check for primitive triple conditions:
                // 1. gcd(m, k) == 1 (coprime)
                // 2. One is even, one is odd -> (m - k) is odd
                if (gcd(m, k) == 1 && (m - k) % 2 == 1) {
                    int c_primitive = m * m + k * k;

                    if (c_primitive > n) {
                        break;
                    }

                    // Add multiples of the primitive triple
                    // Multiply by 2 for both orderings (a,b) and (b,a)
                    cnt += 2 * (n / c_primitive);
                }
            }
        }
        return cnt;
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
