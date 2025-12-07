//Leetcode
//1523. Count Odd Numbers in an Interval Range
//Time complexity: O(1)
//Space complexity: O(1)

package Leetcode;

public class CountOddNumbersInAnIntervalRange_2 {

    public static void main(String[] args) {
        int low = 3, high = 7;
        System.out.println(countOdds(low, high));
    }

    public static int countOdds(int low, int high) {
        return (high + 1) / 2 - low / 2;
    }
}
