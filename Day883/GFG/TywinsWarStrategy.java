//GFG
//Tywin's War Strategy
//Time complexity: O(NlogN)
//Space complexity: O(N)

import java.util.Arrays;

public class TywinsWarStrategy {

    public static void main(String[] args) {
        int[] arr = { 5, 6, 3, 2, 1 };
        int k = 2;
        System.out.println(minSoldiers(arr, k));
    }

    public static int minSoldiers(int[] arr, int k) {
        // code here
        int res[] = new int[arr.length];
        int c = 0;
        for (int i = 0; i < arr.length; i++) {
            res[i] = k - arr[i] % k;
            if (res[i] == k) {
                res[i] = Integer.MAX_VALUE;
                c++;
            }
        }

        if ((arr.length + 1) / 2 <= c)
            return 0;
            
        int s = 0;
        Arrays.sort(res);
        int i = 0;
        while ((arr.length + 1) / 2 > c) {
            s += res[i];
            i++;
            c++;
        }
        return s;
    }
}
