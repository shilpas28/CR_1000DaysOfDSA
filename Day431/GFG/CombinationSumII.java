//GFG
//Combination Sum II
//Time complexity:  O(2^(min(n,p)))
//Space complexity: O(n)

package GFG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumII {

    public static void main(String[] args) {
        int n = 5, k = 7;
        int arr[] = { 1, 2, 3, 3, 5 };
        System.out.println(CombinationSum2(arr, n, k));
    }

    public static List<List<Integer>> CombinationSum2(int arr[], int n, int k) {
        // Code Here.
        Arrays.sort(arr);
        List<Integer> temp = new ArrayList<>();
        Set<List<Integer>> st = new HashSet<List<Integer>>();
        help(arr, n, k, 0, 0, temp, st);
        List<List<Integer>> ans = new ArrayList<>();
        for (List<Integer> lis : st) {
            ans.add(lis);
        }
        Collections.sort(ans, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                int i = 0, j = 0, a = o1.size(), b = o2.size();
                while (i < a && j < b) {
                    if (o1.get(i) != o2.get(j))
                        return o1.get(i).compareTo(o2.get(j));
                    i++;
                    j++;
                }
                if (i < a)
                    return -1;
                return 1;

            }
        });
        return ans;
    }

    static void help(int arr[], int n, int k, int i, int sum, List<Integer> temp, Set<List<Integer>> st) {
        if (sum == k) {
            List<Integer> temp2 = new ArrayList<>();
            temp2.addAll(temp);
            st.add(temp2);
            return;
        }
        if (i == n)
            return;
        help(arr, n, k, i + 1, sum, temp, st);
        if (sum + arr[i] <= k) {
            temp.add(arr[i]);
            help(arr, n, k, i + 1, sum + arr[i], temp, st);
            temp.remove(temp.size() - 1);
        }
    }
}
