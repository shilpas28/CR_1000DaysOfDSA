//GFG
//Longest alternating subsequence
//Time complexity: O(N)
//Space complexity: O(1) 

public class LongestAlternatingSubsequence {

    public static void main(String[] args) {
        int[] arr = { 1, 5, 4 };
        System.out.println(alternatingMaxLength(arr));
    }

    public static int alternatingMaxLength(int[] arr) {
        // code here
        int dec = 1, inc = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1])
                dec = inc + 1;
            else if (arr[i] > arr[i - 1])
                inc = dec + 1;
        }
        return Math.max(inc, dec);
    }
}
