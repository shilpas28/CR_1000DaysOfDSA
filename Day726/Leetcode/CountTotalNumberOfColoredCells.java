//Leetcode
//2579. Count Total Number of Colored Cells - Iterative Addition
//Time complexity: O(N)
//Space complexity: O(1)

public class CountTotalNumberOfColoredCells {

    public static void main(String[] args) {
        int n = 2;
        System.out.println(coloredCells(n));
    }

    public static long coloredCells(int n) {
        long numBlueCells = 1;
        int addend = 4;
        // Iterate n - 1 times
        while (--n > 0) {
            // Add and update current multiple of 4
            numBlueCells += addend;
            addend += 4;
        }
        return numBlueCells;
    }
}
