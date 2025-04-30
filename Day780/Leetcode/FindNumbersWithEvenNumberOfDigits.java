//Leetcode
//1295. Find Numbers with Even Number of Digits
//Time complexity: O(NlogN)
//Space complexity: O(1)

public class FindNumbersWithEvenNumberOfDigits {

    public static void main(String[] args) {
        int[] nums = { 12, 345, 2, 6, 7896 };
        System.out.println(findNumbers(nums));
    }

    public static int findNumbers(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int val = findNoOfDigits(nums[i]);
            if (val % 2 == 0)
                res++;
        }
        return res;
    }

    public static int findNoOfDigits(int num) {
        int count = 0;
        while (num > 0) {
            num = num / 10;
            count++;
        }
        return count;
    }
}
