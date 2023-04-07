//GFG
//Add Minimum Characters - Naive solution 1
//Time complexity: O(N^2)
//Space complexity: O(1)

package GFG;

public class AddMinimumCharacters {

    public static void main(String[] args) {
        String str = "ABCD";
        System.out.println(addMinChar(str));
    }

    public static int addMinChar(String str) {
        // code here
        int plen = 1;
        for (int i = 1; i < str.length(); i++) {
            if (isPalindrome(str, 0, i))
                plen = i + 1;
        }
        return str.length() - plen;
    }

    public static boolean isPalindrome(String str, int low, int high) {
        while (low < high) {
            if (str.charAt(low++) != str.charAt(high--))
                return false;
        }
        return true;
    }
}
