//GFG
//Check if a String is Subsequence of Other
//Time complexity: O(N)
//Space complexity: O(1) 

public class CheckIfAStringIsSubsequenceOfOther {

    public static void main(String[] args) {
        String s1 = "AXY", s2 = "YADXCP";
        System.out.println(isSubSeq(s1, s2));
    }

    public static boolean isSubSeq(String s1, String s2) {
        // code here
        int i = 0, j = 0;
        int n = s1.length();
        int m = s2.length();
        while (i < n && j < m) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i == n;
    }
}
