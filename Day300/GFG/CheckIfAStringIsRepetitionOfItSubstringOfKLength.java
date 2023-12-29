//GFG - Not accepted as last test case is failing
//Check if a string is repetition of its substring of k-length
//Time complexity: O(n)
//Space complexity: O(n)

package GFG;

import java.util.HashMap;
import java.util.Map;

public class CheckIfAStringIsRepetitionOfItSubstringOfKLength {

    public static void main(String[] args) {
        int N = 4;
        int K = 2;
        String S = "bdac";
        System.out.println(kSubstrConcat(N, S, K));
    }

    static int kSubstrConcat(int n, String s, int k) {
        // Your Code Here
        if (n == k)
            return 1;
        if (n % k != 0)
            return 0;
        Map<String, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i += k) {
            String sub = s.substring(i, i + k);
            mp.put(sub, mp.getOrDefault(sub, 0) + 1);
        }
        if (mp.size() > 2) {
            return 0;
        }
        boolean flag = true;
        for (int i : mp.values()) {
            if (i > 1) {
                if (flag) {
                    flag = false;
                } else
                    return 0;
            }
        }
        return 1;
    }
}
