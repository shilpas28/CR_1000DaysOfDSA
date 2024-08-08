//Leetcode
//885. Spiral Matrix III
//Time complexity: O(max(R,C)^2)
//Space complexity: O(R*C) for output

public class SpiralMatrixIII {

    public static void main(String[] args) {
        int rows = 5, cols = 6, rStart = 1, cStart = 4;
        int[][] res = spiralMatrixIII(rows, cols, rStart, cStart);
        for (int[] row : res) {
            for (int val : row) {
                System.out.print(val + " ");
            }
        }
    }

    public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] res = new int[rows * cols][2];
        int dx = 0, dy = 1, n = 0, tmp;
        for (int j = 0; j < rows * cols; ++n) {
            for (int i = 0; i < n / 2 + 1; ++i) {
                if (0 <= rStart && rStart < rows && 0 <= cStart && cStart < cols)
                    res[j++] = new int[] { rStart, cStart };
                rStart += dx;
                cStart += dy;
            }
            tmp = dx;
            dx = dy;
            dy = -tmp;
        }
        return res;
    }
}
