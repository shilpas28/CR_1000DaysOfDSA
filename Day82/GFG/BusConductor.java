//GFG
//Bus Conductor
//Time complexity: O(NlogN)
//Space complexity: O(1)

package GFG;

import java.util.Arrays;

public class BusConductor {

    public static void main(String[] args) {
        int[] chairs = { 3, 1, 5 };
        int[] passengers = { 2, 7, 4 };
        int n = chairs.length;
        System.out.println(findMoves(n, chairs, passengers));
    }

    public static int findMoves(int n, int[] chairs, int[] passengers) {
        // code here
        Arrays.sort(chairs);
        Arrays.sort(passengers);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.abs(chairs[i] - passengers[i]);
        }
        return ans;
    }

}
