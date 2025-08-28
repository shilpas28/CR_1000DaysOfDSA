//GFG
//Maximize Number of 1's
//Time complexity: O(N)
//Space complexity: O(1)

public class MaximizeNumberOf1s {

    public static void main(String[] args) {
        int arr[] = { 1, 0, 0, 1, 0, 1, 0, 1 };
        int k = 2;
        System.out.println(maxOnes(arr, k));
    }

    public static int maxOnes(int arr[], int k) {
        // code here
        int left = 0, zeroCount = 0, maxLength = 0;
        for (int right = 0; right < arr.length; right++) {
            if (arr[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (arr[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
