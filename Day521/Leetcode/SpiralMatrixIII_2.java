//Leetcode
//885. Spiral Matrix III
//Time complexity: O(R*C)
//Space complexity: O(R*c)

public class SpiralMatrixIII_2 {

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
        int[][] dirt = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // east, south, west, north is 0, 1, 2,
                                                                                 // 3
        int[][] res = new int[rows * cols][2];
        int len = 0, d = 0, j = 0; // move <len> steps in the <d> direction
        res[j++] = new int[] { rStart, cStart };
        while (j < rows * cols) { // fill all the blanks
            if (d == 0 || d == 2)
                len++; // when move east or west, the length of path need plus 1
            for (int i = 0; i < len; i++) {
                rStart += dirt[d][0];
                cStart += dirt[d][1];
                if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) // check valid
                    res[j++] = new int[] { rStart, cStart };
            }
            d = (d + 1) % 4; // turn to next direction
        }
        return res;
    }
}
