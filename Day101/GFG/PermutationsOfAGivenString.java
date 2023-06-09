//GFG
//Permutations of a given string
//Time complexity: O(n! * n)
//Space complexity: O(n! * n)

package GFG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PermutationsOfAGivenString {

    public static void main(String[] args) {
        String S = "ABC";
        System.out.println(find_permutation(S));
    }

    static HashMap<String, Integer> mm;
    static List<String> a;

    public static List<String> find_permutation(String S) {
        // Code here
        mm = new HashMap<>();
        a = new ArrayList<>();
        int n = S.length();
        char arr[] = S.toCharArray();
        Arrays.sort(arr);
        a.add(String.valueOf(arr));
        mm.put(String.valueOf(arr), 1);
        int k = 1;
        for (int i = 2; i <= n; i++)
            k *= i;
        k--;
        while (k != 0) {
            compute(arr);
            k--;
        }
        return a;
    }

    static void compute(char ans[]) {
        int i = 0, j = ans.length - 1;
        for (i = ans.length - 2; i >= 0; i--) {
            if (ans[i] < ans[i + 1])
                break;
        }
        if (i < 0)
            return;
        for (int k = ans.length - 1; k > i; k--) {
            if (ans[k] > ans[i]) {
                j = k;
                break;
            }
        }
        char temp = ans[i];
        ans[i] = ans[j];
        ans[j] = temp;
        i++;
        j = ans.length - 1;
        while (i < j) {
            temp = ans[i];
            ans[i] = ans[j];
            ans[j] = temp;
            i++;
            j--;
        }
        String t = String.valueOf(ans);
        if (mm.get(t) == null)
            a.add(t);
        mm.putIfAbsent(t, 0);
        mm.put(t, mm.get(t) + 1);
    }
}
