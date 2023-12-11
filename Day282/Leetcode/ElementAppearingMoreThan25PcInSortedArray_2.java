//Leetcode
//1287. Element Appearing More Than 25% In Sorted Array
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

public class ElementAppearingMoreThan25PcInSortedArray_2 {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 6, 6, 6, 6, 7, 10 };
        System.out.println(findSpecialInteger(arr));
    }

    public static int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int freq[] = new int[1_00_001];
        for (int i : arr) {
            freq[i]++;
        }
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > n / 4)
                return i;
        }
        return -1;
    }
}
