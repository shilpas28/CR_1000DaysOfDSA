//GFG
//Find Pair Given Difference - Not accepted as TLE
//Time complexity: O(n^2)
//Space complexity: O(1)

package GFG;

public class FindPairGivenDifference {

    public static void main(String[] args) {
        int n = 6;
        int x = 78;
        int arr[] = { 5, 20, 3, 2, 5, 80 };
        System.out.println(findPair(n, x, arr));
    }

    public static int findPair(int n, int x, int[] arr) {
        // code here
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++)
                if (Math.abs(arr[i] - arr[j]) == x)
                    return 1;
        }
        return -1;
    }
}
