//Leetcode
//912. Sort an Array - Top down Merge Sort
//Time complexity: O(NlogN)
//Space complexity: O(N)

public class SortAnArray_5 {

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
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    static void mergeSort(int[] nums, int l, int r) {
        if (l >= r)
            return;
        int mid = l + (r - l) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, l, r);
    }

    static void merge(int[] nums, int l, int r) {
        int mid = l + (r - l) / 2;
        int[] tmp = new int[r - l + 1];
        int i = l, j = mid + 1, k = 0;
        while (i <= mid || j <= r) {
            if (i > mid || j <= r && nums[i] > nums[j]) {
                tmp[k++] = nums[j++];
            } else {
                tmp[k++] = nums[i++];
            }
        }
        System.arraycopy(tmp, 0, nums, l, r - l + 1);
    }
}
