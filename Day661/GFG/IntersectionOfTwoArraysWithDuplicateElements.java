//GFG
//Intersection of Two arrays with Duplicate Elements
//Time complexity: O( a.size() + b.size() )
//Space complexity: O( a.size() )

package GFG;

import java.util.ArrayList;
import java.util.HashMap;

public class IntersectionOfTwoArraysWithDuplicateElements {

    public static void main(String[] args) {
        int a[] = { 1, 2, 1, 3, };
        int b[] = { 3, 1, 3, 4, 1 };
        System.out.println(intersectionWithDuplicates(a, b));
    }

    public static ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> mm = new HashMap<>();
        for (int x : a)
            mm.put(x, 1);
        for (int x : b) {
            if (mm.get(x) != null && mm.get(x) != 0) {
                ans.add(x);
                mm.put(x, 0);
            }
        }
        return ans;
    }
}
