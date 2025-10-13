//Leetcode
//2273. Find Resultant Array After Removing Anagrams - Using Sorting
//Time complexity: O(n∗LlogL)
//Space complexity: O(n)

package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindResultantArrayAfterRemovingAnagrams_2 {

    public static void main(String[] args) {
        String[] words = { "abba", "baba", "bbaa", "cd", "cd" };
        System.out.println(removeAnagrams(words));
    }

    public static List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        ans.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            char[] a = words[i].toCharArray(), b = ans.get(ans.size() - 1).toCharArray();
            Arrays.sort(a);
            Arrays.sort(b);
            if (!Arrays.equals(a, b))
                ans.add(words[i]);
        }
        return ans;
    }
}
