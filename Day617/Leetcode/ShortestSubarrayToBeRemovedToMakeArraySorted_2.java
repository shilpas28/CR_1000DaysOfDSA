//Leetcode
//1574. Shortest Subarray to be Removed to Make Array Sorted
//Time complexity: O(N)
//Space complexity: O(1)

public class ShortestSubarrayToBeRemovedToMakeArraySorted_2 {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 10, 4, 2, 3, 5 };
        System.out.println(findLengthOfShortestSubarray(arr));
    }

    public static int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length, l = 0, r = n - 1;
        while (l + 1 < n && arr[l] <= arr[l + 1])
            ++l;
        if (l == n - 1)
            return 0;
        while (r > l && arr[r - 1] <= arr[r])
            --r;
        int res = Math.min(n - l - 1, r);
        for (int i = 0, j = r; i <= l && j < n;)
            if (arr[i] <= arr[j])
                res = Math.min(res, j - i++ - 1);
            else
                ++j;
        return res;
    }
}
