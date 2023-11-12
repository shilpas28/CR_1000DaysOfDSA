//Leetcode
//Check if string is rotated by two places
//Time complexity: O(N)
//Space complexity: O(N)

package GFG;

public class CheckIfStringIsRotatedByTwoPlaces_2 {

    public static void main(String[] args) {
        String a = "amazon";
        String b = "azonam";
        System.out.println(isRotated(a, b));
    }

    // Function to check if a string can be obtained by rotating
    // another string by exactly 2 places.
    public static boolean isRotated(String str1, String str2) {
        String clock_rot = "";
        String anticlock_rot = "";
        int len = str2.length();

        // Initialize string as anticlockwise rotation
        anticlock_rot = anticlock_rot + str2.substring(len - 2, len) + str2.substring(0, len - 2);
        // Initialize string as clockwise rotation
        clock_rot = clock_rot + str2.substring(2) + str2.substring(0, 2);
        // Check is any of them is equal to string1
        return (str1.equals(clock_rot) || str1.equals(anticlock_rot));
    }
}
