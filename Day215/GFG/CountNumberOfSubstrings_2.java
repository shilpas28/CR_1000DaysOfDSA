//GFG - Code accepted 
//Count number of substrings
//Time complexity: O(|S|)
//Space complexity: O(1)

package GFG;

public class CountNumberOfSubstrings_2 {

    public static void main(String[] args) {
        String S = "aba";
        int K = 2;
        System.out.println(substrCount(S, K));
    }

    static long substrCount(String S, int K) {
        // your code here
        return atMostKDistinct(S, K) - atMostKDistinct(S, K - 1);
    }

    static long atMostKDistinct(String s, int k) {
        if (k < 0)
            return 0;

        int i = 0, j = 0, cnt = 0;
        long ans = 0;
        int charCount[] = new int[26];

        while (j < s.length()) {
            char currentChar = (char) (s.charAt(j) - 'a');
            charCount[currentChar]++;
            if (charCount[currentChar] == 1)
                cnt++;
            while (cnt > k) {
                char removedChar = (char) (s.charAt(i) - 'a');
                charCount[removedChar]--;
                if (charCount[removedChar] == 0) {
                    cnt--;
                }
                i++;
            }
            ans += (j - i + 1); // form all substrings
            j++;
        }
        return ans;
    }
}
