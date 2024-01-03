//GFG
//Smallest window containing 0, 1 and 2
//Time complexity: O(length(S))
//Space complexity: O(1)

package GFG;

public class SmallestWindowContaining01And2 {

    public static void main(String[] args) {
        String S = "01212";
        System.out.println(smallestSubstring(S));
    }

    public static int smallestSubstring(String S) {
        // Code here
        int zero = -1, one = -1, two = -1, res = 100001;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '0')
                zero = i;
            if (S.charAt(i) == '1')
                one = i;
            if (S.charAt(i) == '2')
                two = i;

            if (zero == -1 || one == -1 || two == -1)
                continue;
            int min = Math.min(Math.min(one, zero), two);
            int max = Math.max(Math.max(one, zero), two);
            res = Math.min(res, max - min + 1);
        }
        return res == 100001 ? -1 : res;
    }
}
