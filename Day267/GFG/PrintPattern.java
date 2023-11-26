//GFG
//Print Pattern
//Time complexity: O(N)
//Space complexity: O(N)

package GFG;

import java.util.ArrayList;
import java.util.List;

public class PrintPattern {

    public static void main(String[] args) {
        int N = 16;
        System.out.println(pattern(N));
    }

    static List<Integer> ans = new ArrayList<Integer>();

    public static List<Integer> pattern(int N) {
        // code here
        if (N <= 0) {
            ans.add(N);
            return ans;
        }
        ans.add(N);
        pattern(N - 5);
        ans.add(N);
        return ans;
    }
}
