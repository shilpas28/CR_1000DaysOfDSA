//Leetcode
//1861. Rotating the Box
//Time complexity: O(m*n)
//Space complexity: O(m*n)

package Leetcode;

public class RotatingTheBox_2 {

    public static void main(String[] args) {
        char[][] box = { { '#', '.', '#' } };
        char[][] res = rotateTheBox(box);
        for (char[] row : res) {
            for (char val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;

        for (char[] row : box) {
            int dropPos = n - 1;

            for (int currPos = n - 1; currPos >= 0; currPos--) {
                if (row[currPos] == '*') {
                    dropPos = currPos - 1;
                } else if (row[currPos] == '#') {
                    char temp = row[dropPos];
                    row[dropPos] = row[currPos];
                    row[currPos] = temp;
                    dropPos--;
                }
            }
        }

        char[][] rotatedBox = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotatedBox[j][m - 1 - i] = box[i][j];
            }
        }
        return rotatedBox;
    }
}
