//Leetcode
//1295. Find Numbers with Even Number of Digits
//Time complexity: O(N)
//Space complexity: O(1)

public class FindNumbersWithEvenNumberOfDigits_2 {

    public static void main(String[] args) {
        int[] nums = { 12, 345, 2, 6, 7896 };
        System.out.println(findNumbers(nums));
    }

    public static int findNumbers(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {

            if ((nums[i] > 9 && nums[i] < 100) || (nums[i] > 999 && nums[i] < 10000) || nums[i] == 100000) {
                count++;
            }
        }
        return count;
    }
}
