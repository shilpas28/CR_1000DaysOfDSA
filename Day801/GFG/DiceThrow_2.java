//GFG
//Dice throw - Memoization
//Time complexity: O(m*n)
//Space complexity: O(x)

import java.util.HashMap;

public class DiceThrow_2 {

    public static void main(String[] args) {
        int m = 6, n = 3, x = 12;
        System.out.println(noOfWays(m, n, x));
    }

    static int noOfWays(int m, int n, int x) {
        // code here
        return ways(m, n, x, new HashMap<>());
    }

    static int ways(int m, int n, int x, HashMap<String, Integer> map) {
        if (x == 0 && n == 0) {
            return 1;
        }
        if (n <= 0 || x <= 0)
            return 0;
        String key = n + " " + x;
        if (map.containsKey(key))
            return map.get(key);
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            ans += ways(m, n - 1, x - i, map);
        }
        map.put(key, ans);
        return ans;
    }
}
