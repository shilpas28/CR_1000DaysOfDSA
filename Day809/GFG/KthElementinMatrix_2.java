//GFG
//Kth element in Matrix
//Time complexity: O(n * log (mat[i][j]))
//Space complexity: O(1)

public class KthElementinMatrix_2 {

    public static void main(String[] args) {
        int mat[][] = { { 16, 28, 60, 64 }, { 22, 41, 63, 91 }, { 27, 50, 87, 93 }, { 36, 78, 87, 94 } };
        int k = 3;
        System.out.println(kthSmallest(mat, k));
    }

    public static int kthSmallest(int[][] matrix, int k) {
        // code here
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = countLessEqual(matrix, mid);

            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    static int countLessEqual(int[][] matrix, int target) {
        int n = matrix.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] <= target) {
                    count++;
                }
            }
        }

        return count;
    }
}
