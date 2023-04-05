//GFG
//Count Special Numbers
//Time complexity: O(N*root(M)) where M = max(arr[i])
//Space complexity: O(N)

import java.util.HashMap;

public class CountSpecialNumbers_1 {

    public static void main(String[] args) {
        int N = 3;
        int arr[] = { 2, 3, 6 };
        System.out.println(countSpecialNumbers(N, arr));
    }

    public static int countSpecialNumbers(int N, int arr[]) {
        // Code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int MAX = Integer.MIN_VALUE;

        for (int in : arr)
            MAX = Math.max(MAX, in);
        boolean[] factors = new boolean[MAX + 1];

        for (int i = 0; i < N; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
                continue;

            }
            for (int j = 2 * arr[i]; j <= MAX; j += arr[i]) {
                factors[j] = true;
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int ans = 0;
        for (int i : arr) {
            if (factors[i] || map.get(i) > 1)
                ans++;
        }
        return ans;
    }
}
