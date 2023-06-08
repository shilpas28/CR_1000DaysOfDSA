//Leetcode
//1351. Count Negative Numbers in a Sorted Matrix
//Time complexity: O(n+m)
//Space complexity: O(1)

package Leetcode;

public class CountNegativeNumbersInASortedMatrix {

	public static void main(String[] args) {
		int[][] grid = {
			{
				4, 3, 2, -1
			},
			{
				3, 2, 1, -1
			},
			{
				1, 1, -1, -2
			},
			{-1, -1, -2, -3
			}
		};
		System.out.println(countNegatives(grid));
	}

	public static int countNegatives(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int r = n - 1, c = 0, cnt = 0;

		while (r >= 0 && c  <  m) {
			if (grid[r][c]<0) {
				--r;
				cnt += m - c;
			} else
				++c;
		}
		return cnt;
	}
}