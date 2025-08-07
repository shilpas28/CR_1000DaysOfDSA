//Leetcode
//3363. Find the Maximum Number of Fruits Collected
//Time complexity: O(N^2)
//Space complexity: O(1)

public class FindTheMaximumNumberOfFruitsCollected_2 {

    public static void main(String[] args) {
        int[][] fruits = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        System.out.println(maxCollectedFruits(fruits));
    }

    public static int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i < j && j < n - 1 - i)
                    fruits[i][j] = 0;
                if (j < i && i < n - 1 - j)
                    fruits[i][j] = 0;
            }
        }
        // First child (main diagonal)
        int res = 0;
        for (int i = 0; i < n; ++i) {
            res += fruits[i][i];
        }
        // Second child (top-right to bottom-left)
        for (int i = 1; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                fruits[i][j] += Math.max(
                        fruits[i - 1][j - 1],
                        Math.max(fruits[i - 1][j], (j + 1 < n) ? fruits[i - 1][j + 1] : 0));
            }
        }
        // Third child (bottom-left to top-right)
        for (int j = 1; j < n; ++j) {
            for (int i = j + 1; i < n; ++i) {
                fruits[i][j] += Math.max(
                        fruits[i - 1][j - 1],
                        Math.max(fruits[i][j - 1], (i + 1 < n) ? fruits[i + 1][j - 1] : 0));
            }
        }
        return res + fruits[n - 1][n - 2] + fruits[n - 2][n - 1];
    }
}
