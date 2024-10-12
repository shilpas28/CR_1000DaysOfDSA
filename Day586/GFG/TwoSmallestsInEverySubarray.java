//GFG
//Two Smallests in Every Subarray
//Time complexity: O(N)
//Space complexity: O(1)

public class TwoSmallestsInEverySubarray {

    public static void main(String[] args) {
        int[] arr = { 4, 3, 1, 5, 6 };
        System.out.println(pairWithMaxSum(arr));
    }

    public static int pairWithMaxSum(int[] arr) {
        // code here
        if (arr.length == 1)
            return -1;
        int max = 0;
        for (int i = 1; i < arr.length; i++)
            max = Math.max(max, arr[i - 1] + arr[i]);
        return max;
    }
}
