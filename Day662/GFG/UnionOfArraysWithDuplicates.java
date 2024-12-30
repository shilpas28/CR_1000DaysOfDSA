//GFG
//Union of Arrays with Duplicates
//Time complexity: O(n+m)
//Space complexity: O(n+m) 

import java.util.HashMap;

public class UnionOfArraysWithDuplicates {

    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4, 5 };
        int b[] = { 1, 2, 3 };
        System.out.println(findUnion(a, b));
    }

    public static int findUnion(int a[], int b[]) {
        // code here
        int ans = 0;
        HashMap<Integer, Integer> mm = new HashMap<>();
        for (int x : a) {
            if (mm.get(x) == null)
                ans++;
            mm.put(x, 1);
        }
        for (int x : b) {
            if (mm.get(x) == null)
                ans++;
            mm.put(x, 1);
        }
        return ans;
    }
}
