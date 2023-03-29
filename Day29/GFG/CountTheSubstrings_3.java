//GFG - Optimal solution
//Count the Substrings
//Time complexity: O(N)
//Space complexity: O(N)

package GFG;

import java.util.HashMap;

public class CountTheSubstrings_3 {

    public static void main(String[] args) {
        String S = "gEEk";
        // String S = "WomensDAY";
        System.out.println(countSubstring(S));

    }

    static int countSubstring(String S) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0;
        int sum = 0;
        for (char ch : S.toCharArray()) {
            int val;
            if (Character.isUpperCase(ch)) {
                val = 1;
            } else {
                val = -1;
            }

            sum += val;

            if (map.containsKey(sum)) {
                ans += map.get(sum);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
