//GFG - Accepted solution
//Check if a string is repetition of its substring of k-length
//Time complexity: O(n)
//Space complexity: O(n)

package GFG;

import java.util.HashSet;

public class CheckIfAStringIsRepetitionOfItSubstringOfKLength_2 {

    public static void main(String[] args) {
        int N = 4;
        int K = 2;
        String S = "bdac";
        System.out.println(kSubstrConcat(N, S, K));
    }

    static int kSubstrConcat(int n, String s, int k) {
        // Your Code Here
        if (n % k != 0) {
            return 0;
        }
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < n; i += k) {
            hs.add(s.substring(i, i + k));
            if (hs.size() > 2) {
                return 0;
            }
        }
        if (hs.size() == 2 || hs.size() == 1) {
            return 1;
        }
        return 0;
    }
}
