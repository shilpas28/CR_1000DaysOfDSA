//GFG
//Recamans sequence
//Time complexity: O(n)
//Space complexity: O(n)

package GFG;

import java.util.ArrayList;
import java.util.HashMap;

public class RecamansSequence {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(recamanSequence(n));
    }

    static ArrayList<Integer> recamanSequence(int n) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> mm = new HashMap<>();
        ans.add(0);
        mm.put(0, 1);
        for (int i = 1; i < n; i++) {
            if (ans.get(i - 1) - i > 0 && mm.get(ans.get(i - 1) - i) == null) {
                ans.add(ans.get(i - 1) - i);
                mm.put(ans.get(i - 1) - i, 1);
            } else {
                ans.add(ans.get(i - 1) + i);
                mm.put(ans.get(i - 1) + i, 1);
            }
        }
        return ans;
    }
}
