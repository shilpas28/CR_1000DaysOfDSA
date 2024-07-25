//Leetcode
//912. Sort an Array - Bubble Sort - Not accepted as TLE
//Time complexity: O(N^2)
//Space complexity: O(1)

public class SortAnArray {

    public static void main(String[] args) {
        int[] nums = { 5, 2, 3, 1 };
        int[] res = sortArray(nums);
        for (int val : res) {
            System.out.print(val + " ");
        }
    }

    public static int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return nums;
        bubbleSort(nums);
        return nums;
    }

    static void bubbleSort(int[] nums) {
        for (int k = nums.length - 1; k >= 1; k--) {
            for (int i = 0; i < k; i++) {
                if (nums[i] > nums[i + 1])
                    swap(nums, i, i + 1);
            }
        }
    }

    static void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
