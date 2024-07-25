//Leetcode
//912. Sort an Array - Heap Sort
//Time complexity: O(NlogN)
//Space complexity: O(1)

public class SortAnArray_7 {

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
        heapSort(nums);
        return nums;
    }

    static void heapSort(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            heapify(nums, i, nums.length - 1);
        }
        for (int i = nums.length - 1; i >= 1; i--) {
            swap(nums, 0, i);
            heapify(nums, 0, i - 1);
        }
    }

    static void heapify(int[] nums, int i, int end) {
        while (i <= end) {
            int l = 2 * i + 1, r = 2 * i + 2;
            int maxIndex = i;
            if (l <= end && nums[l] > nums[maxIndex])
                maxIndex = l;
            if (r <= end && nums[r] > nums[maxIndex])
                maxIndex = r;
            if (maxIndex == i)
                break;
            swap(nums, i, maxIndex);
            i = maxIndex;
        }
    }

    static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
