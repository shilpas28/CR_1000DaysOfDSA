//GFG - Brute force but accepted by GFG 
//Count the Substrings
//Time complexity: O(N^2)
//Space complexity: O(1)

package GFG;

public class CountTheSubstrings_2 {

    public static void main(String[] args) {
        String S = "gEEk";
        // String S = "WomensDAY";
        System.out.println(countSubstring(S));

    }

    static int countSubstring(String S) {
        // code here
        int ans = 0;
        for (int i = 0; i < S.length(); i++) {
            int c = 0;
            for (int j = i; j < S.length(); j++) {
                if (Character.isLowerCase(S.charAt(j)))
                    c++;
                else
                    c--;

                if (c == 0)
                    ans++;
            }
        }
        return ans;
    }
}
