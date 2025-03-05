//Leetcode
//2579. Count Total Number of Colored Cells - Mathematical Formula
//Time complexity: O(1)
//Space complexity: O(1) 

public class CountTotalNumberOfColoredCells_2 {

    public static void main(String[] args) {
        int n = 2;
        System.out.println(coloredCells(n));
    }

    public static long coloredCells(int n) {
        return 1 + (long) n * (n - 1) * 2;
    }
}
