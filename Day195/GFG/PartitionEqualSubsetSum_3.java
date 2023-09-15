//GFG
//Partition Equal Subset Sum - Space optimization
//Time complexity: O(N*K) +O(N). There are two nested loops that account for O(N*K) 
//and at starting we are running a for loop to calculate totSum. 
//Space complexity: O(K). We are using an external array of size ‘K+1’ to store only one row. 

package GFG;

public class PartitionEqualSubsetSum_3 {

    public static void main(String[] args) {
        int N = 4;
        int[] arr = { 1, 5, 11, 5 };
        System.out.println(equalPartition(N, arr));
    }

    static int equalPartition(int N, int arr[]) {
        // code here
        boolean res = equalPartitionHelper(N, arr);
        if (res == false)
            return 0;
        else
            return 1;
    }

    static boolean equalPartitionHelper(int N, int arr[]) {
        // code here
        int totSum = 0;

        for (int i = 0; i < N; i++) {
            totSum += arr[i];
        }

        if (totSum % 2 == 1)
            return false;

        else {
            int k = totSum / 2;
            boolean prev[] = new boolean[k + 1];

            prev[0] = true;

            if (arr[0] <= k)
                prev[arr[0]] = true;

            for (int ind = 1; ind < N; ind++) {
                boolean cur[] = new boolean[k + 1];
                cur[0] = true;
                for (int target = 1; target <= k; target++) {
                    boolean notTaken = prev[target];

                    boolean taken = false;
                    if (arr[ind] <= target)
                        taken = prev[target - arr[ind]];

                    cur[target] = notTaken || taken;
                }
                prev = cur;
            }
            return prev[k];
        }
    }
}
