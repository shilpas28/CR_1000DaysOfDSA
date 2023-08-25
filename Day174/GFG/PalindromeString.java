//GFG
//Palindrome String
//Time complexity: O(Length of S)
//Space complexity: O(1)

package GFG;

public class PalindromeString {

    public static void main(String[] args) {
        String S = "abba";
        System.out.println(isPalindrome(S));
    }

    static int isPalindrome(String S) {
        // code here
        int n = S.length();
        for (int i = 0; i < n / 2; i++) {
            if (S.charAt(i) != S.charAt(n - 1 - i))
                return 0;
        }
        return 1;
    }
}
