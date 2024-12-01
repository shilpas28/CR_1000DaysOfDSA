//Leetcode
//1346. Check If N and Its Double Exist - Binary Search
//Time complexity: O(NlogN)
//Space complexity: O(1)

import java.util.Arrays;

public class CheckIfNAndItsDoubleExist_4 {

    public static void main(String[] args) {
        int[] arr = { 10, 2, 5, 3 };
        System.out.println(checkIfExist(arr));
    }

    public static boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int target = 2 * arr[i];
            int lo = 0, hi = arr.length - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (arr[mid] == target && mid != i)
                    return true;
                if (arr[mid] < target)
                    lo = mid + 1;
                else
                    hi = mid - 1;
            }
        }
        return false;
    }
}
