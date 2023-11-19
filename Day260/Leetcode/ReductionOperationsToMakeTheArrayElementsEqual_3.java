//Leetcode
//1887. Reduction Operations to Make the Array Elements Equal
//Time complexity: O(n) - where n is the length of the input array nums. The algorithm iterates through the array once.
//Space complexity: O(1) - as the extra space used is constant (the freq array has a fixed size). 

package Leetcode;

public class ReductionOperationsToMakeTheArrayElementsEqual_3 {

    public static void main(String[] args) {
        int[] nums = { 5, 1, 3 };
        System.out.println(reductionOperations(nums));
    }

    public static int reductionOperations(int[] nums) {
        int n = nums.length;
        int[] freq = new int[50001];
        for (int i = 0; i < n; i++) {
            freq[nums[i]]++;
        }
        int res = 0, operations = 0;
        for (int i = 50000; i >= 1; i--) {
            if (freq[i] > 0) {
                operations += freq[i];
                res += operations - freq[i];
            }
        }
        return res;
    }
}
