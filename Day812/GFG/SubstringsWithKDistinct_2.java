//GFG
//Substrings with K Distinct
//Time complexity: O(|S|)
//Space complexity: O(1) 

public class SubstringsWithKDistinct_2 {

    public static void main(String[] args) {
        String s = "abc";
        int k = 2;
        System.out.println(countSubstr(s, k));
    }

    static int countSubstr(String s, int k) {
        // your code here
        return (int) (atMostKDistinct(s, k) - atMostKDistinct(s, k - 1));
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
