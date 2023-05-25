//GFG
//Maximum Identical Bowls
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class MaximumIdenticalBowls {

    public static void main(String[] args) {
        int N = 3;
        int arr[] = { 3, 1, 5 };
        System.out.println(getMaximum(N, arr));
    }

    public static int getMaximum(int N, int[] arr) {
        // code here
        long sum = 0;
        for (int i = 0; i < N; i++)
            sum += arr[i];
        for (int i = N; i >= 0; i--) {
            if (sum % i == 0)
                return i;
        }
        return 1;
    }
}
