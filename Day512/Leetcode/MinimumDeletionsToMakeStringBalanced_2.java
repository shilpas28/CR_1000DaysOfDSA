//Leetcode
//1653. Minimum Deletions to Make String Balanced
//Time complexity: O(n) where n = s.length()
//Space complexity: O(1)

public class MinimumDeletionsToMakeStringBalanced_2 {

    public static void main(String[] args) {
        String s = "aababbab";
        System.out.println(minimumDeletions(s));
    }

    public static int minimumDeletions(String s) {
        int a = s.chars().map(i -> i == 'a' ? 1 : 0).sum();
        int cnt = a, b = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'b') {
                cnt = Math.min(cnt, a + b++);
            } else {
                --a;
            }
        }
        return Math.min(cnt, b);
    }
}
