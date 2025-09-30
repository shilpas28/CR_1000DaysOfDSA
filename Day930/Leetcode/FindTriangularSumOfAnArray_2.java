//Leetcode
//2221. Find Triangular Sum of an Array
//Time complexity: O(N^2)
//Space complexity: O(1) 

public class FindTriangularSumOfAnArray_2 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        System.out.println(triangularSum(nums));
    }

    public static int triangularSum(int[] nums) {
        return find(nums, nums.length);
    }

    public static int find(int[] a, int n) {
        if (n == 1)
            return a[0];

        for (int i = 0; i < n - 1; i++) {
            a[i] = (a[i] + a[i + 1]) % 10;
        }
        return find(a, n - 1);
    }
}
