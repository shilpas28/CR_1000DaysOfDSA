//Leetcode
//1460. Make Two Arrays Equal by Reversing Subarrays - Counting Sort
//Time complexity: O(N)
//Space complexity: O(1)

public class MakeTwoArraysEqualByReversingSubarrays_5 {

    public static void main(String[] args) {
        int[] target = { 1, 2, 3, 4 };
        int[] arr = { 2, 4, 1, 3 };
        System.out.println(canBeEqual(target, arr));
    }

    public static boolean canBeEqual(int[] target, int[] arr) {
        int[] elementCounts = new int[1001];
        int uniqueCount = 0;

        for (int i = 0; i < target.length; i++) {
            if (elementCounts[target[i]]++ == 0)
                uniqueCount++;
            if (elementCounts[arr[i]]-- == 1)
                uniqueCount--;
        }
        return uniqueCount == 0;
    }
}
