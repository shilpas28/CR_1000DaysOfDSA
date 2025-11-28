//GFG
//Subset XOR
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

import java.util.ArrayList;

public class SubsetXOR {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(subsetXOR(n));
    }

    public static ArrayList<Integer> subsetXOR(int n) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int mod = n % 4;
        // determine element to skip (-1 means skip none)
        int skip = -1;
        if (mod == 0) {
            skip = -1; // keep all
        } else if (mod == 3) {
            skip = n;  // remove n
        } else if (mod == 2) {
            skip = 1;  // remove 1
        } else { // mod == 1
            if (n == 1) {
                skip = -1; // keep all (1)
            } else {
                skip = n - 1;     // remove n-1

            }
        }

        for (int i = 1; i <= n; i++) {
            if (i == skip) {
                continue;
            }
            ans.add(i);
        }
        return ans;
    }
}
