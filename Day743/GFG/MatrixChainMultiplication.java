//GFG
//Matrix Chain Multiplication - Not accepted as TLE 
//Time complexity: O(N^3)
//Space complexity: O(N^2)

public class MatrixChainMultiplication {

    public static void main(String[] args) {
        int arr[] = { 2, 1, 3, 4 };
        System.out.println(matrixMultiplication(arr));
    }

    static int matrixMultiplication(int arr[]) {
        // code here
        int N = arr.length;
        int i = 1;
        int j = N - 1;

        return f(arr, i, j);
    }

    static int f(int[] arr, int i, int j) {
        // base condition
        if (i == j)
            return 0;
        int mini = Integer.MAX_VALUE;
        // partioning loop
        for (int k = i; k <= j - 1; k++) {

            int ans = f(arr, i, k) + f(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];

            mini = Math.min(mini, ans);

        }
        return mini;
    }
}
