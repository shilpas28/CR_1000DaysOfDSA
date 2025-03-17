//Leetcode
//2206. Divide Array Into Equal Pairs - Boolean Array
//Time complexity: O(N)
//Space complexity: O(maxNum) where maxNum is the largest number in nums

public class DivideArrayIntoEqualPairs_3 {

    public static void main(String[] args) {
        int[] nums = { 3, 2, 3, 2, 2, 2 };
        System.out.println(divideArray(nums));
    }

    public static boolean divideArray(int[] nums) {
        // Find maximum value in array
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(num, maxNum);
        }
        // Toggle pair status for each number
        boolean[] needsPair = new boolean[maxNum + 1];
        for (int num : nums) {
            needsPair[num] = !needsPair[num];
        }
        // Check if any number remains unpaired
        for (int num : nums) {
            if (needsPair[num]) {
                return false;
            }
        }
        return true;
    }
}
