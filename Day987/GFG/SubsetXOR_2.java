//GFG
//Subset XOR
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

import java.util.ArrayList;

public class SubsetXOR_2 {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(subsetXOR(n));
    }

    public static ArrayList<Integer> subsetXOR(int n) {
        // code here
        int xor = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            xor ^= i;
            ans.add(i);
        }

        if (xor == n) {
            return ans;
        } else {
            int k = xor ^ n;
            ans.remove(Integer.valueOf(k));
            return ans;
        }
    }
}
