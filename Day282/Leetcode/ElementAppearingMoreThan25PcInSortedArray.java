//Leetcode
//1287. Element Appearing More Than 25% In Sorted Array
//Time complexity: O(N^2)
//Space complexity: O(1)

package Leetcode;

public class ElementAppearingMoreThan25PcInSortedArray {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 6, 6, 6, 6, 7, 10 };
        System.out.println(findSpecialInteger(arr));
    }

    public static int findSpecialInteger(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j])
                    count++;
            }
            if (count > n / 4)
                return arr[i];
        }
        return -1;
    }
}
