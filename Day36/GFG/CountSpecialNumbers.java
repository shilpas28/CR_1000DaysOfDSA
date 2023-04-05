//GFG
//Count Special Numbers
//Time complexity:
//Space complexity:

import java.util.HashMap;

public class CountSpecialNumbers {

    public static void main(String[] args) {
        int N = 3;
        int arr[] = { 2, 3, 6 };
        System.out.println(countSpecialNumbers(N, arr));
    }

    public static int countSpecialNumbers(int N, int arr[]) {
        // Code here
        HashMap<Integer, Boolean> map = new HashMap<>();
        boolean[] res = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (map.containsKey(arr[i])) {
                res[i] = map.get(arr[i]);
                continue;
            }
            for (int j = 0; j < N; j++) {
                if (i != j && arr[i] % arr[j] == 0) {
                    res[i] = true;
                    break;
                }
            }
            map.put(arr[i], res[i]);
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (res[i])
                ans++;
        }
        return ans;
    }
}
