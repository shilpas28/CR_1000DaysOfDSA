//GFG
//Palindrome SubStrings
//Time complexity: O(N^2)
//Space complexity: O(1) 

public class PalindromeSubStrings {

    public static void main(String[] args) {
        String s = "abaab";
        System.out.println(countPS(s));
    }

    public static int countPS(String s) {
        // code here
        int count = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            count += expandAroundCenter(s, i, i);
            count += expandAroundCenter(s, i, i + 1);
        }
        return count;
    }

    static int expandAroundCenter(String s, int left, int right) {
        int count = 0;
        int n = s.length();
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            if (right - left + 1 >= 2) {
                count++;
            }
            left--;
            right++;
        }
        return count;
    }
}
