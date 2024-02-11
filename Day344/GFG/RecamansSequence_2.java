//GFG
//Recamans sequence
//Time complexity: O(n)
//Space complexity: O(n)

package GFG;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RecamansSequence_2 {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(recamanSequence(n));
    }

    static ArrayList<Integer> recamanSequence(int n) {
        // code here
        ArrayList<Integer> al = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        al.add(0);

        for (int i = 1; i < n; i++) {
            int ans = al.get(i - 1) - i;
            if (ans > 0 && !set.contains(ans)) {
                al.add(ans);
                set.add(ans);
            } else {
                al.add(al.get(i - 1) + i);
                set.add(al.get(i - 1) + i);
            }
        }
        return al;
    }
}
