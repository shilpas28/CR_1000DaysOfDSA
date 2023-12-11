//Leetcode
//1287. Element Appearing More Than 25% In Sorted Array
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class ElementAppearingMoreThan25PcInSortedArray_3 {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 6, 6, 6, 6, 7, 10 };
        System.out.println(findSpecialInteger(arr));
    }

    public static int findSpecialInteger(int[] arr) {
        int count = 0;
        int n = arr.length;
        int prev = -1;
        int req = n / 4;
        for (int i : arr) {
            if (i == prev) {
                count++;
            } else {
                prev = i;
                count = 1;
            }
            if (count > req) {
                return i;
            }
        }
        return -1;
    }
}
