//GFG - Brute force
//Count the Substrings
//Time complexity: O(N^2)
//Space complexity: O(1)

package GFG;

public class CountTheSubstrings {

    public static void main(String[] args) {
        String S = "gEEk";
        // String S = "WomensDAY";
        System.out.println(countSubstring(S));

    }

    static int countSubstring(String S) {
        // code here
        int cnt = 0;
        int ans = 0;
        for (int i = 0; i < S.length(); i++) {
            cnt = 0;
            for (int j = i; j < S.length(); j++) {
                if (S.charAt(j) >= 'a' && S.charAt(j) <= 'z')
                    cnt++;

                else
                    cnt--;

                if (cnt == 0)
                    ans++;
            }
        }
        return ans;
    }
}
