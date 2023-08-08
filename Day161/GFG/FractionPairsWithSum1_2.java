//GFG 
//Fraction pairs with sum 1
//Time complexity: O(N*log(N))
//Space complexity: O(N) 

package GFG;

import java.util.HashMap;

public class FractionPairsWithSum1_2 {

    public static void main(String[] args) {
        int N = 4;
        int[] numerator = { 1, 2, 2, 8 };
        int[] denominator = { 2, 4, 6, 12 };
        System.out.println(countFractions(N, numerator, denominator));
    }

    public static int countFractions(int n, int[] numerator, int[] denominator) {
        // code here
        int ans = 0;
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = numerator[i], y = denominator[i];
            int g = gcd(x, y);
            x /= g;
            y /= g;
            int n_x = y - x;
            //int n_y = y;
            // checking if 1-x/y is present in map - if yes -incerement the cnt;
            if (map.containsKey(n_x) && map.get(n_x).containsKey(y)) {
                ans += map.get(n_x).get(y);
            }
            // checking if some fractions have same num - push the denom in value(itself
            // map)
            if (map.containsKey(x)) {
                HashMap<Integer, Integer> hm = map.get(x);
                hm.put(y, hm.getOrDefault(y, 0) + 1);
            }
            // new fraction coming up.
            else {
                HashMap<Integer, Integer> hm = new HashMap<>();
                hm.put(y, 1);
                map.put(x, hm);
            }
        }
        return ans;
    }

    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
