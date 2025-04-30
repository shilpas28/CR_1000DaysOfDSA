//Leetcode
//1295. Find Numbers with Even Number of Digits
//Time complexity: O(N)
//Space complexity: O(1)

public class FindNumbersWithEvenNumberOfDigits_3 {

    public static void main(String[] args) {
        int[] nums = { 12, 345, 2, 6, 7896 };
        System.out.println(findNumbers(nums));
    }

    public static int findNumbers(int[] nums) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {

            int count = (int) Math.log10(nums[i]) + 1;

            if (count % 2 == 0)
                result++;
        }

        return result;
    }
}
