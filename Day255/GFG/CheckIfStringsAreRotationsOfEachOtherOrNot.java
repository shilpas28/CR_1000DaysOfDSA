//GFG
//Check if strings are rotations of each other or not
//Time complexity: O(|s1|)
//Sapce complexity: O(|s1|)

package GFG;

public class CheckIfStringsAreRotationsOfEachOtherOrNot {

    public static void main(String[] args) {
        String s1 = "geeksforgeeks";
        String s2 = "forgeeksgeeks";
        System.out.println(areRotations(s1, s2));
    }

    // Function to check if two strings are rotations of each other or not.
    public static boolean areRotations(String s1, String s2) {
        // Your code here
        return ((s1 + s1).indexOf(s2) >= 0);
    }
}
