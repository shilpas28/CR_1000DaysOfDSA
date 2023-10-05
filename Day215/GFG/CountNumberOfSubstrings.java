//GFG - giving TLE
//Count number of substrings
//Time complexity: O(|S|)
//Space complexity: O(1)

package GFG;

public class CountNumberOfSubstrings {

    public static void main(String[] args) {
        String S = "aba";
        int K = 2;
        System.out.println(substrCount(S, K));
    }

    static long substrCount(String S, int K) {
        // your code here
        return atmost(S, K) - atmost(S, K - 1);
    }

    static long atmost(String s, int k) {

        int arr[] = new int[26];
        int dist = 0, left = 0;
        long res = 0;

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            if (arr[s.charAt(i) - 'a'] == 1)
                dist++;
            while (dist > k) {
                arr[s.charAt(left) - 'a']--;
                if (arr[s.charAt(left) - 'a'] == 0)
                    dist--;
                left++;
            }
            res = res + (i - left + 1);
        }
        return res;
    }
}
