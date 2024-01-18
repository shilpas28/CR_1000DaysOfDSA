//GFG
//All Unique Permutations of an array
//Time complexity: O(n*n!)
//Space complexity: O(n*n!)

package GFG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class AllUniquePermutationsOfAnArray {

    public static void main(String[] args) {
        int n = 3;
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(1);
        System.out.println(uniquePerms(arr, n));
    }

    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr, int n) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        HashSet<ArrayList<Integer>> mm = new HashSet<>();
        helper(arr, n, mm, 0);
        for (ArrayList<Integer> temp : mm)
            ans.add(temp);
        Collections.sort(ans, new Comparator<List<Integer>>() {
            public int compare(List<Integer> a, List<Integer> b) {
                int i = 0;
                while (i < n) {
                    if (a.get(i).compareTo(b.get(i)) != 0)
                        return a.get(i).compareTo(b.get(i));
                    i++;
                }
                return 0;
            }
        });
        return ans;
    }

    static void helper(ArrayList<Integer> arr, int n, HashSet<ArrayList<Integer>> mm, int index) {
        if (index == n) {
            ArrayList<Integer> nn = new ArrayList<>(arr);
            mm.add(nn);
            return;
        }
        for (int i = index; i < n; i++) {
            int a = arr.get(i);
            int b = arr.get(index);
            arr.set(i, b);
            arr.set(index, a);
            helper(arr, n, mm, index + 1);
            arr.set(i, a);
            arr.set(index, b);
        }
    }
}
