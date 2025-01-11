//GFG
//Longest substring with distinct characters - Using Character Array as GFG is not accepting HashSet 
//Time complexity: O(N)
//Space complexity: O(1)

public class LongestSubstringWithDistinctCharacters_5 {

    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println(longestUniqueSubstr(s));
    }

    public static int longestUniqueSubstr(String s) {
        // code here
        int n = s.length();
        int frequency[] = new int[26];
        char str[] = s.toCharArray();
        int j = 0;
        int longest = 1;

        for (int i = 0; i < n; i++) {
            while (frequency[str[i] - 'a'] > 0) {
                frequency[str[j] - 'a']--;
                j++;
            }
            frequency[str[i] - 'a']++;
            longest = Math.max(longest, i - j + 1);
        }
        return longest;
    }
}
