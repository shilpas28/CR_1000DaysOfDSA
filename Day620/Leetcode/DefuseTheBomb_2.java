//Leetcode
//1652. Defuse the Bomb
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.Arrays;

public class DefuseTheBomb_2 {

    public static void main(String[] args) {
        int[] code = { 5, 7, 1, 4 };
        int k = 3;
        System.out.println(Arrays.toString(decrypt(code, k)));
    }

    public static int[] decrypt(int[] code, int k) {
        int N = code.length, sum = 0;
        int[] res = new int[N], S = new int[N];
        if (k == 0)
            return res;

        // Calculate Prefix Sum Array
        S[0] = code[0];
        for (int i = 1; i < N; i += 1) {
            S[i] = S[i - 1] + code[i];
        }

        if (k > 0) {
            for (int i = 0; i < N; i += 1) {
                int L = (i + 1);
                int R = (i + k);
                /*
                 * If R < N. It means there are k numbers exist -> to the right of ith number
                 * don't need to move in circular way.
                 */
                if (R < N) {
                    sum += (S[R] - S[L - 1]);
                    /*
                     * If R >= N, means we've to move in circular way
                     * to get sum of k next numbers.
                     */
                } else {
                    sum += (S[N - 1] - S[L - 1]);
                    // Adding remaining numbers from the front.
                    sum += S[R % N];
                }

                res[i] = sum;
                sum = 0;
            }
            // If k < 0
        } else {
            for (int i = 0; i < N; i += 1) {
                int L = (i - 1);
                int R = (i + k);

                /*
                 * If either of one or both is negative, means
                 * some numbers(may be all) of k previous numbers are exist in
                 * right side ith number and others are left side.
                 * 
                 * To manipulate L & R with prefix sum we're adding
                 * N to L & R.
                 * 
                 * If both L & R are >= 0, means all the previous k numbers
                 * are exist in the left side of ith number.
                 */
                if (L < 0 || R < 0) {
                    int _L = L + N;
                    int _R = R + N;
                    L = Math.min(_L, _R);
                    R = Math.max(_L, _R);
                }

                int _L = L, _R = R;
                L = Math.min(_L, _R);
                R = Math.max(_L, _R);

                if (R < N) {
                    sum += (S[R] - ((L - 1) >= 0 ? S[L - 1] : 0));
                    /*
                     * If R >= N, means we've to move in circular way
                     * to get sum of k previous numbers.
                     */
                } else {
                    sum += (S[N - 1] - S[L - 1]);
                    // Adding remaining numbers from the front.
                    sum += S[R % N];
                }

                res[i] = sum;
                sum = 0;
            }
        }
        return res;
    }
}
