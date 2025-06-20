//GFG
//Group Balls by Sequence
//Time complexity: O(N)
//Space complexity: O(N)

public class GroupBallsBySequence_2 {

    public static void main(String[] args) {
        int arr[] = { 10, 1, 2, 11 };
        int k = 2;
        System.out.println(validgroup(arr, k));
    }

    public static boolean validgroup(int[] arr, int k) {
        // code here
        int max = 0;
        for (int i : arr)
            max = Math.max(max, i);
        int temp[] = new int[max + 1];
        int dp[] = new int[max + 1];
        for (int i : arr) {
            temp[i]++;
        }
        int cur = 0;
        for (int i = 0; i <= max; i++) {
            cur += dp[i];
            if (temp[i] < cur)
                return false;
            if (temp[i] > cur) {
                int x = temp[i] - cur;
                cur += x;
                if (i + k <= max)
                    dp[i + k] -= x;
                if (i + k > max + 1)
                    return false;
            }
        }
        return true;
    }
}
