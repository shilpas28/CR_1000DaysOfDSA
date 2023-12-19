//Leetcode
//661. Image Smoother
//Time complexity: O(m*n) - The nested loops iterate through each cell in the original image, resulting in a 
//time complexity of O(m∗n)O(m * n)O(m∗n), where m is the number of rows and n is the number of columns.
//Space complexity: O(m*n) - The additional space used is for the result matrix, which has the same dimensions as the input 
//image. Therefore, the space complexity is O(m∗n)O(m * n)O(m∗n), where m is the number of rows and n is the number of columns.

package Leetcode;

public class ImageSmoother_2 {

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
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                int totalSum = 0;
                int count = 0;

                for (int x = Math.max(0, i - 1); x < Math.min(rows, i + 2); ++x) {
                    for (int y = Math.max(0, j - 1); y < Math.min(cols, j + 2); ++y) {
                        totalSum += img[x][y];
                        count += 1;
                    }
                }

                result[i][j] = totalSum / count;
            }
        }
        return result;
    }
}
