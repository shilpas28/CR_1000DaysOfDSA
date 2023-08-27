//GFG
//Reverse a String
//Time complexity: O(|S|).
//Space complexity: O(1)

package GFG;

public class ReverseAString {

    public static void main(String[] args) {
        String s = "Geeks";
        System.out.println(reverseWord(s));
    }

    // Complete the function
    // str: input string
    public static String reverseWord(String str) {
        // Reverse the string str
        StringBuffer sb = new StringBuffer("");
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
