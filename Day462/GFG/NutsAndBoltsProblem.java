//GFG
//Nuts and Bolts Problem
//Time complexity: O(N)
//Space complexity: O(9)

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NutsAndBoltsProblem {

    public static void main(String[] args) {
        int n = 5;
        char nuts[] = { '@', '%', '$', '#', '^' };
        char bolts[] = { '%', '@', '#', '$', '^' };
        matchPairs(n, nuts, bolts);
        System.out.println(Arrays.toString(nuts));
        System.out.println(Arrays.toString(bolts));
    }

    static void matchPairs(int n, char nuts[], char bolts[]) {
        // code here
        char temp[] = { '!', '#', '$', '%', '&', '*', '?', '@', '^' };
        Map<Character, Integer> mm = new HashMap<>();
        for (int i = 0; i < n; i++)
            mm.put(nuts[i], 1);
        int j = 0;
        for (int i = 0; i < 9; i++) {
            if (mm.get(temp[i]) != null) {
                nuts[j] = temp[i];
                bolts[j] = temp[i];
                j++;
            }
        }
    }
}
