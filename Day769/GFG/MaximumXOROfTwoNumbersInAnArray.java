//GFG
//Maximum XOR of two numbers in an array
//Time complexity: O(NlogN)
//Space complexity: O(N)

public class MaximumXOROfTwoNumbersInAnArray {

    public static void main(String[] args) {
        int arr[] = { 25, 10, 2, 8, 5, 3 };
        System.out.println(maxXor(arr));
    }

    public static int maxXor(int[] arr) {
        // code here
        int n = arr.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                res = Math.max(res, arr[i] ^ arr[j]);
            }
        }
        return res;
    }
}
