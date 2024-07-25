//Leetcode
//912. Sort an Array - Selection Sort - Not accepted as TLE
//Time complexity: O(N^2)
//Space complexity: O(1) 

public class SortAnArray_2 {

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
        selectionSort(nums);
        return nums;
    }

    static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex])
                    minIndex = j;
            }
            if (minIndex != i)
                swap(nums, i, minIndex);
        }
    }

    static void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
