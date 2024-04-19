//GFG
//Find missing in second array
//Time complexity: O(n+m)
//Space complexity: O(m)

package GFG;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FindMissingInSecondArray {

    public static void main(String[] args) {
        int n = 6, m = 5;
        int a[] = { 1, 2, 3, 4, 5, 10 };
        int b[] = { 2, 3, 1, 0, 5 };
        System.out.println(findMissing(a, b, n, m));
    }

    static ArrayList<Integer> findMissing(int a[], int b[], int n, int m) {
        Set<Integer> s = new HashSet<Integer>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < m; i++)
            s.add(b[i]);
        for (int i = 0; i < n; i++)
            if (!s.contains(a[i]))
                ans.add(a[i]);
        return ans;
    }
}
