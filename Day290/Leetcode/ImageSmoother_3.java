//Leetcode
//661. Image Smoother
//Time complexity: O(rows∗cols)
//Space complexity: O(rows∗cols) or O(1). If we can ignore output matrix, we can say O(1).

package Leetcode;

public class ImageSmoother_3 {

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

    public static int[][] imageSmoother(int[][] img) {
        int rows = img.length;
        int cols = img[0].length;

        // Apply the average function to each pixel in the image matrix
        int[][] result = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                result[r][c] = calculateAverage(img, r, c, rows, cols);
            }
        }

        return result;
    }

    static int calculateAverage(int[][] img, int r, int c, int rows, int cols) {
        int total = 0;
        int count = 0;

        // Define the boundaries for the neighboring pixels
        int top = Math.max(0, r - 1);
        int bottom = Math.min(rows, r + 2);
        int left = Math.max(0, c - 1);
        int right = Math.min(cols, c + 2);

        // Iterate over the neighboring pixels and calculate the sum and count
        for (int row = top; row < bottom; row++) {
            for (int col = left; col < right; col++) {
                total += img[row][col];
                count += 1;
            }
        }

        // Calculate and return the average value for the pixel
        return total / count;
    }
}
