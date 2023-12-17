//GFG
//Max Sum without Adjacents
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class MaxSumWithoutAdjacents {

    public static void main(String[] args) {
        int N = 6;
        int Arr[] = { 5, 5, 10, 100, 10, 5 };
        System.out.println(findMaxSum(Arr, N));
    }

    static int findMaxSum(int arr[], int n) {
        // code here
        if (n == 1)
            return arr[0];

        for (int i = 2; i < n; i++) {
            arr[i] = arr[i] + arr[i - 2];
            arr[i - 1] = Math.max(arr[i - 1], arr[i - 2]);
        }

        return Math.max(arr[n - 1], arr[n - 2]);
    }
}
