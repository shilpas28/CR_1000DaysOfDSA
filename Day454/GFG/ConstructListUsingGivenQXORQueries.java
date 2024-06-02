//GFG
//Construct list using given q XOR queries
//Time complexity: O(q*log(q))
//Space complexity: O(l), where l is only used for output-specific requirements.

import java.util.ArrayList;
import java.util.Collections;

public class ConstructListUsingGivenQXORQueries {

    public static void main(String[] args) {
        int q = 5;
        int queries[][] = { { 0, 6 }, { 0, 3 }, { 0, 2 }, { 1, 4 }, { 1, 5 } };
        System.out.println(constructList(q, queries));
    }

    public static ArrayList<Integer> constructList(int q, int[][] queries) {
        // code here
        int x = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = q - 1; i >= 0; i--) {
            if (queries[i][0] == 1)
                x ^= queries[i][1];
            else
                ans.add(queries[i][1] ^ x);
        }
        ans.add(x);
        Collections.sort(ans);
        return ans;
    }
}
