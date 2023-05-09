//GFG
//Count Binary Strings With No Consecutive 1s
//Time complexity: O(log(N))
//Space complexity: O(Height of the recursive call stack)

public class CountBinaryStringsWithNoConsecutive1s {

    public static void main(String[] args) {
        long N = 3;
        System.out.println(countStrings(N));
    }

    static int modulus = 1000000007;
    public static int countStrings(long N) {
        // Code here
        // We use matrix power to find the value of F(n+1) where F(i) is the ith
        // Fibonacci number
        /*
         * The number of binary strings of length n without consecutive 1's is just the
         * (n+1)th Fibonacci number
         * We use matrix power to compute F(n+1) since the matrix representation of
         * Fibonacci numbers
         * has a property that can be used to compute them efficiently
         */
        return matrixPower(new int[][] { { 1, 1 }, { 1, 0 } }, N + 1)[0][0];
    }

    // This function takes a 2x2 matrix a and a long n and returns the matrix power
    // a^n
    static int[][] matrixPower(int[][] a, long n) {
        int[][] result = new int[][] { { 1, 0 }, { 0, 1 } }; // Initialize the result matrix to the identity matrix
        while (n > 0) {
            if (n % 2 == 1) {
                result = multiplyMatrices(result, a); // If n is odd, multiply result by a
            }
            a = multiplyMatrices(a, a); // Square a
            n /= 2; // Divide n by 2
        }
        return result; // Return the matrix power a^n
    }

    // This function takes two 2x2 matrices a and b and returns their product
    static int[][] multiplyMatrices(int[][] a, int[][] b) {
        int[][] result = new int[2][2]; // Initialize the result matrix to 0
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    result[i][j] = (int) ((result[i][j] + (long) a[i][k] * b[k][j]) % modulus); // Compute the (i, j)th
                                                                                                // entry of the product
                                                                                                // matrix
                }
            }
        }
        return result; // Return the product matrix
    }

}
