//Leetcode
//661. Image Smoother
//Time complexity: O(8*M*N + M*N) = O(M*N)
//Space complexity: O(1)

package Leetcode;

public class ImageSmoother_4 {

    public static void main(String[] args) {
        int[][] img = { { 100, 200, 100 }, { 200, 50, 200 }, { 100, 200, 100 } };
        int[][] res = imageSmoother(img);
        for (int[] row : res) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    static final int[][] DIRS = { { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 }, { -1, 0 },
            { -1, 1 } };

    public static int[][] imageSmoother(int[][] img) {
        if (img == null) {
            throw new IllegalArgumentException("Input image is null");
        }
        if (img.length == 0 || img[0].length == 0) {
            return img;
        }

        int rows = img.length;
        int cols = img[0].length;
        if (rows == 1 && cols == 1) {
            return img;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int sum = img[i][j];
                int count = 1;
                for (int[] d : DIRS) {
                    int x = i + d[0];
                    int y = j + d[1];
                    if (x >= 0 && x < rows && y >= 0 && y < cols) {
                        sum += img[x][y] & 0xFF;
                        count++;
                    }
                }
                img[i][j] |= (sum / count) << 8;
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                img[i][j] >>>= 8;
            }
        }

        return img;
    }
}
