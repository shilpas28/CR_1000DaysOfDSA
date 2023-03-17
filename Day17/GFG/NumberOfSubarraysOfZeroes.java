//GFG - doesnt accept this as TLE
//Number of Subarrays of 0's
//Time complexity: O(N^2)
//Space compelxity: O(1)

public class NumberOfSubarraysOfZeroes {

    public static void main(String[] args) {
        int N = 4;
        int arr[] = { 0, 0, 1, 0 };
        System.out.println(no_of_subarrays(N, arr));
    }

    static long no_of_subarrays(int N, int[] arr) {
        // Write your code here
        long ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                if (arr[j] == 0)
                    ans++;
                else
                    break;
            }
        }
        return ans;
    }

}
