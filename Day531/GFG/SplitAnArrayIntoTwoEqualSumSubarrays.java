//GFG
//Split an array into two equal Sum subarrays
//Time complexity: O(N)
//Space complexity: O(1)

public class SplitAnArrayIntoTwoEqualSumSubarrays {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 5 };
        System.out.println(canSplit(arr));
    }

    public static boolean canSplit(int arr[]) {
        // code here
        int sum = 0, firstSum = 0;
        for (int x : arr)
            sum += x;
        for (int x : arr) {
            sum -= x;
            firstSum += x;
            if (firstSum == sum)
                return true;
        }
        return false;
    }
}
