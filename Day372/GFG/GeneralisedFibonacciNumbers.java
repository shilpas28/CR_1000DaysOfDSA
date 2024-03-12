//GFG
//Generalised Fibonacci numbers
//Time complexity: O(log(n))
//Space complexity: O(1)

package GFG;

public class GeneralisedFibonacciNumbers {

    public static void main(String[] args) {
        long a = 3;
        long b = 3;
        long c = 3;
        long n = 3;
        long m = 5;
        System.out.println(genFibNum(a, b, c, n, m));
    }

    static long genFibNum(Long a, Long b, Long c, long n, long m) {
        // code here
        if (n <= 2)
            return 1 % m;
        long mat[][] = { { a, b, 1 }, { 1, 0, 0 }, { 0, 0, 1 } };
        long ans[][] = power(mat, n - 2, m);

        return (ans[0][0] + ans[0][1] + c * ans[0][2]) % m;
    }

    static long[][] power(long[][] mat, long R, long m) {
        if (R == 1)
            return mat;
        long ans[][] = power(mat, R / 2, m);
        ans = multiply(ans, ans, m);
        if (R % 2 == 1)
            ans = multiply(ans, mat, m);
        return ans;
    }

    static long[][] multiply(long[][] A, long[][] B, long m) {

        int size = A.length;
        long result[][] = new long[size][size];

        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                for (int k = 0; k < size; k++)
                    result[i][j] = (result[i][j] + (A[i][k] % m * B[k][j] % m) % m) % m;
        return result;
    }
}
