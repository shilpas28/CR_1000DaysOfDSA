//Leetcode
//Check if string is rotated by two places
//Time complexity: O(N)
//Space complexity: O(N)

package GFG;

public class CheckIfStringIsRotatedByTwoPlaces {

    public static void main(String[] args) {
        String a = "amazon";
        String b = "azonam";
        System.out.println(isRotated(a, b));
    }

    // Function to check if a string can be obtained by rotating
    // another string by exactly 2 places.
    public static boolean isRotated(String str1, String str2) {
        // Your code here
        int l1 = str1.length();
        int l2 = str2.length();
        if (l1 != l2)
            return false;

        String one = str2.substring(2) + str2.substring(0, 2);
        String two = str2.substring(l1 - 2) + str2.substring(0, l1 - 2);

        if (str1.equals(one))
            return true;
        if (str1.equals(two))
            return true;

        return false;
    }
}
