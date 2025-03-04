//GFG
//Longest Increasing Subsequence
//Time complexity: O(NlogN)
//Space complexity: O(N)

public class LongestIncreasingSubsequence_2 {

    public static void main(String[] args) {
        int arr[] = { 5, 8, 3, 7, 9, 1 };
        System.out.println(lis(arr));
    }

    static int lis(int arr[]) {
        // code here
        int[] tails = new int[arr.length];
        int size = 0;
        for (int x : arr) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size)
                ++size;
        }
        return size;
    }
}
