//GFG
//Palindrome with minimum sum
//Time complexity: O(N)
//Space complexity: O(1) 

package GFG;

public class PalindromeWithMinimumSum {

    public static void main(String[] args) {
        String S = "a???c??c????";
        System.out.println(minimumSum(S));
    }

    public static int minimumSum(String s) {
        // code here
        return possible(s) ? solve(s) : -1;
    }

    public static boolean possible(String s) {
        int low = 0, high = s.length() - 1;
        while (low < high) {
            if (s.charAt(low) != '?' && s.charAt(high) != '?' && s.charAt(low) != s.charAt(high))
                return false;
            low++;
            high--;
        }
        return true;
    }

    public static int solve(String st) {
        char[] s = st.toCharArray();
        int low = 0, high = s.length - 1;
        while (low < high) {
            if (s[low] == '?')
                s[low] = s[high];
            else if (s[high] == '?')
                s[high] = s[low];

            low++;
            high--;
        }
        int i = 0;
        while (i < s.length && s[i] == '?')
            i++;
        if (i == s.length)
            return 0;

        char prev = s[i];
        int ans = 0;
        for (int x = i + 1; x < s.length; x++) {
            if (s[x] == '?')
                s[x] = prev;
            ans += Math.abs(s[x] - prev);
            prev = s[x];
        }
        return ans;
    }
}
