//Leetcode
//Check if string is rotated by two places - Optimal method 
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class CheckIfStringIsRotatedByTwoPlaces_3 {

    public static void main(String[] args) {
        String a = "amazon";
        String b = "azonam";
        System.out.println(isRotated(a, b));
    }

    // Function to check if a string can be obtained by rotating
    // another string by exactly 2 places.
    public static boolean isRotated(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;

        int n = str1.length();
        boolean clockwise = true;
        boolean anticlockwise = true;

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) != str2.charAt((i + 2) % n)) {
                clockwise = false;
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (str1.charAt((i + 2) % n) != str2.charAt(i)) {
                anticlockwise = false;
                break;
            }
        }

        return (clockwise || anticlockwise);
    }
}
