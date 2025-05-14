//Leetcode
//3337. Total Characters in String After Transformations II
//Time complexity: O(∣s∣ + ((26^3)*logt))
//Space complexity: O(26^2)

import java.util.ArrayList;
import java.util.List;

public class TotalCharactersInStringAfterTransformationsII {

    public static void main(String[] args) {
        String s = "abcyy";
        int t = 2;
        int[] largeArray = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2 };
        List<Integer> nums = new ArrayList<>();
        for (int num : largeArray)
            nums.add(num);
        System.out.println(lengthAfterTransformations(s, t, nums));
    }

    static final int mod = 1000000007;

    public static int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        long[][] transform = new long[26][26];
        for (int i = 0; i < 26; i++) {
            for (int shift = 0; shift < nums.get(i); shift++) {
                transform[i][(i + 1 + shift) % 26]++;
            }
        }
        transform = powerMatrix(transform, t);
        long[][] freq = new long[1][26];
        for (char ch : s.toCharArray()) {
            freq[0][ch - 'a']++;
        }
        freq = multiplyMatrices(freq, transform);
        long total = 0;
        for (long cnt : freq[0]) {
            total = (total + cnt) % mod;
        }
        return (int) total;
    }

    static long[][] multiplyMatrices(long[][] A, long[][] B) {
        int rowsA = A.length, colsA = A[0].length, colsB = B[0].length;
        long[][] result = new long[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                long sum = 0;
                for (int k = 0; k < colsA; k++) {
                    sum = (sum + (A[i][k] * B[k][j]) % mod) % mod;
                }
                result[i][j] = sum;
            }
        }
        return result;
    }

    static long[][] powerMatrix(long[][] matrix, long exponent) {
        int n = matrix.length;
        long[][] result = new long[n][n];
        for (int i = 0; i < n; i++)
            result[i][i] = 1;
        while (exponent > 0) {
            if ((exponent & 1) == 1)
                result = multiplyMatrices(result, matrix);
            matrix = multiplyMatrices(matrix, matrix);
            exponent >>= 1;
        }
        return result;
    }
}
