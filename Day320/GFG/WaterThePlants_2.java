//GFG
//Water the plants
//Time complexity: O(n)
//Space complexity: O(n)

package GFG;

import java.util.Arrays;

public class WaterThePlants_2 {

    public static void main(String[] args) {
        int n = 6;
        int gallery[] = { -1, 2, 2, -1, 0, 0 };
        System.out.println(min_sprinklers(gallery, n));
    }

    static int min_sprinklers(int gallery[], int n) {
        // code here
        int plant[] = new int[n];
        Arrays.fill(plant, -1);
        for (int i = 0; i < n; i++) {
            if (gallery[i] != -1) {
                int a = Math.max(0, i - gallery[i]);
                int b = Math.min(n - 1, i + gallery[i]);
                for (int j = a; j <= b; j++) {
                    plant[j] = Math.max(plant[j], b);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (plant[i] == -1)
                return -1;
            if (i <= plant[i]) {
                ans++;
                i = plant[i];
            }
        }
        return ans;
    }
}
