//GFG - Not accepted as TLE
//Smaller Sum - Brute Force method
//Time complexity: O(N^2)
//Space complexity: O(N)

import java.util.ArrayList;
import java.util.Arrays;

public class SmallerSum {

    public static void main(String[] args) {
        int n = 3;
        int[] arr = { 1, 2, 3 };
        System.out.println(Arrays.toString(smallerSum(n, arr)));
    }

    public static long[] smallerSum(int n, int arr[]) {
        ArrayList<Long> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long cnt = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] < arr[i]) {
                    cnt += arr[j];
                }
            }
            ans.add(cnt);
        }
        return ans.stream().mapToLong(i -> i).toArray();
    }
}
