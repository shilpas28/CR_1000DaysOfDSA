//GFG
//String stack
//Time complexity: O(n+m)
//Space complexity: O(1)

public class StringStack {

    public static void main(String[] args) {
        String pat = "geuaek", tar = "geek";
        System.out.println(stringStack(pat, tar));
    }

    public static boolean stringStack(String pat, String tar) {
        // code here
        int n = pat.length();
        int m = tar.length();
        int i = n - 1, j = m - 1; // start from end

        while (i >= 0 && j >= 0) {
            if (pat.charAt(i) == tar.charAt(j)) {
                // match, move both
                i--;
                j--;
            } else {
                // simulate delete: skip two characters in pat
                i -= 2;
            }
        }

        return j < 0;
    }
}
