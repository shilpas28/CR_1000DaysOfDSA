//GFG
//K-Pangrams
//Time complexity: O(N)
//Space complexity: O(1) 

import java.util.HashSet;
import java.util.Set;

public class KPangrams {

    public static void main(String[] args) {
        String str = "the quick brown fox jumps over the lazy dog";
        int k = 0;
        System.out.println(kPangram(str, k));
    }

    static boolean kPangram(String str, int k) {
        // code here
        int n = 0;
        Set<Character> set = new HashSet<>(26);
        for (char c : str.toCharArray()) {
            if (c == ' ')
                continue;
            set.add(c);
            n++;
        }

        if (n < 26)
            return false;
        int unique = set.size();
        int need = 26 - unique;
        return need <= k;
    }
}
