//GFG
//Add Minimum Characters - Naive solution 2
//Time complexity: O(N^2)
//Space complexity: O(1)

package GFG;

public class AddMinimumCharacters_1 {

    public static void main(String[] args) {
        String str = "ABCD";
        System.out.println(addMinChar(str));
    }

    public static int addMinChar(String str) {
        // code here
        int n = str.length();
        int i = 0, j = n - 1, lpfs = n - 1;

        while (i < j) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                i = 0;
                lpfs--;
                j = lpfs;
            }
        }
        return n - lpfs - 1;
    }
}
