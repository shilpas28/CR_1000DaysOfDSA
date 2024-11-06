//Leetcode
//3011. Find if Array Can Be Sorted
//Time complexity: O(N^2)
//Space complexity: O(1) 

public class FindIfArrayCanBeSorted {

    public static void main(String[] args) {
        int[] nums = { 8, 4, 2, 30, 15 };
        System.out.println(canSortArray(nums));
    }

    public static boolean canSortArray(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                int k = nums[j], c = 0;
                while (k > 0) {
                    k = k & (k - 1);
                    c++;
                }
                k = nums[j + 1];
                int c1 = 0;
                while (k > 0) {
                    k = k & (k - 1);
                    c1++;
                }
                if (c == c1 && nums[j] > nums[j + 1])
                    swap(nums, j, j + 1);
            }
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1])
                return false;
        }
        return true;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
