//Leetcode
//1460. Make Two Arrays Equal by Reversing Subarrays - XOR-based Approach
//Time complexity: O(N^2)
//Space complexity: O(1)

public class MakeTwoArraysEqualByReversingSubarrays {

    public static void main(String[] args) {
        int[] target = { 1, 2, 3, 4 };
        int[] arr = { 2, 4, 1, 3 };
        System.out.println(canBeEqual(target, arr));
    }

    public static boolean canBeEqual(int[] target, int[] arr) {
        int xor = 0;
        for (int i = 0; i < target.length; i++)
            xor ^= target[i] ^ arr[i];

        if (xor != 0)
            return false;

        for (int num : target) {
            if (count(target, num) != count(arr, num))
                return false;
        }
        return true;
    }

    static int count(int[] array, int target) {
        int count = 0;
        for (int num : array) {
            if (num == target)
                count++;
        }
        return count;
    }
}
