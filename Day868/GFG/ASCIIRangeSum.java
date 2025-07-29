//GFG
//ASCII Range Sum
//Time complexity: O(N)
//Space complexity: O(1)

import java.util.ArrayList;

public class ASCIIRangeSum {

    public static void main(String[] args) {
        String s = "abacab";
        System.out.println(asciirange(s));
    }

    public static ArrayList<Integer> asciirange(String s) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int n = s.length(), sum = 0;
        for (int x = 0; x < n; x++) {
            char ch = s.charAt(x);
            int fi = s.indexOf(ch), li = s.lastIndexOf(ch);
            if (fi != li && fi == x) {
                for (int y = fi + 1; y < li; y++) {
                    sum += (int) s.charAt(y);
                }
                if (sum != 0) {
                    ans.add(sum);
                    sum = 0;
                }

            }
        }
        return ans;
    }
}
