//Leetcode
//661. Image Smoother
//Time complexity: O(m * n), where m and n are the dimensions of the image matrix. We iterate through each cell once.
//Space complexity: O(m * n), the space required for the result matrix.

package Leetcode;

public class ImageSmoother {

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
        int res[][] = new int[img.length][img[0].length];
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[0].length; j++) {
                res[i][j] = smoothen(img, i, j);
            }
        }
        return res;
    }

    static int smoothen(int[][] img, int x, int y) {
        int m = img.length;
        int n = img[0].length;
        int sum = 0;
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nx = x + i;
                int ny = y + j;
                if (nx < 0 || nx >= m || ny < 0 || ny >= n)
                    continue;
                sum += img[nx][ny];
                count++;
            }
        }
        return sum / count;
    }

}
