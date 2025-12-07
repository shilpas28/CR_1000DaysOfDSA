//Leetcode
//1523. Count Odd Numbers in an Interval Range
//Time complexity: O(1)
//Space complexity: O(1)

package Leetcode;

public class CountOddNumbersInAnIntervalRange {

    public static void main(String[] args) {
        int low = 3, high = 7;
        System.out.println(countOdds(low, high));
    }

    public static int countOdds(int low, int high) {
        int nums = high - low + 1;  //counting total numbers in range

        if (low % 2 != 0 && high % 2 != 0) {
            return nums / 2 + 1; 
        }else {
            return nums / 2;
        }
    }
}
