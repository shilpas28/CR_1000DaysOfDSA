//Leetcode
//2825. Make String a Subsequence Using Cyclic Increments
//Time complexity: O(N1+N2) ~= O(N)
//Space complexity: O(1) 

public class MakeStringASubsequenceUsingCyclicIncrements_2 {

    public static void main(String[] args) {
        String str1 = "abc", str2 = "ad";
        System.out.println(canMakeSubsequence(str1, str2));
    }

    public static boolean canMakeSubsequence(String str1, String str2) {
        int i = 0, j = 0; // Two Pointers
        int n1 = str1.length();
        int n2 = str2.length();

        while (i < n1 && j < n2) {
            if ((str2.charAt(j) - str1.charAt(i) + 26) % 26 <= 1)
                j++;
            i++;
        }
        return j == n2;
    }
}
