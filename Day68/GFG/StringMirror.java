//GFG
//String Mirror
//Time complexity: O(|str|)
//Space complexity: O(|str|)

package GFG;

public class StringMirror {

    public static void main(String[] args) {
        String str = "bvdfndkn";
        System.out.println(stringMirror(str));
    }

    public static String stringMirror(String str) {
        // code here
        StringBuilder ans = new StringBuilder();
        ans.append(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            // curr ch if higher, break,we need smallest.
            if (str.charAt(i - 1) > str.charAt(i) || (i > 1 && str.charAt(i) == str.charAt(i - 1)))
                ans.append(str.charAt(i));
            else
                break;
        }
        String curr = ans.toString();
        return curr + ans.reverse().toString();
    }
}
