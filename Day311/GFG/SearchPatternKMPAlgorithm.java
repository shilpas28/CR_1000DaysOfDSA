//GFG
//Search Pattern (KMP-Algorithm)
//Time complexity: O(|txt|).
//Space complexity: O(|txt|).

package GFG;

import java.util.ArrayList;

public class SearchPatternKMPAlgorithm {

    public static void main(String[] args) {
        String txt = "geeksforgeeks";
        String pat = "geek";
        System.out.println(search(pat, txt));
    }

    static ArrayList<Integer> search(String pat, String txt) {
        // your code here
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;
        while (true) {
            int index = txt.indexOf(pat, i);
            if (index == -1)
                break;
            else {
                ans.add(index + 1);
                i = index + 1;
            }
        }
        if (ans.size() == 0)
            ans.add(-1);
        return ans;
    }
}
