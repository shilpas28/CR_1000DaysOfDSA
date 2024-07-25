//Leetcode
//912. Sort an Array - Quick Sort - Not accepted as TLE
//Time complexity: O(N^2)
//Space complexity: O(logN)

public class SortAnArray_4 {

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
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    static void quickSort(int[] nums, int l, int r) {
        if (l >= r)
            return;
        int mid = partition(nums, l, r);
        quickSort(nums, l, mid);
        quickSort(nums, mid + 1, r);
    }

    static int partition(int[] nums, int l, int r) {
        int pivot = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= pivot)
                r--;
            nums[l] = nums[r];
            while (l < r && nums[l] <= pivot)
                l++;
            nums[r] = nums[l];
        }
        nums[l] = pivot;
        return l;
    }
}
