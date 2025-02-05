//Leetcode
//1790. Check if One String Swap Can Make Strings Equal - Only Check Differences
//Time complexity: O(N)
//Space complexity: O(1)

public class CheckIfOneStringSwapCanMakeStringsEqual_2 {

    public static void main(String[] args) {
        String s1 = "bank", s2 = "kanb";
        System.out.println(areAlmostEqual(s1, s2));
    }

    public static boolean areAlmostEqual(String s1, String s2) {
        int firstIndexDiff = 0;
        int secondIndexDiff = 0;
        int numDiffs = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                numDiffs++;
                // numDiffs is more than 2, one string swap will not make two strings equal
                if (numDiffs > 2)
                    return false;
                else if (numDiffs == 1) {
                    // store the index of first difference
                    firstIndexDiff = i;
                } else {
                    // store the index of second difference
                    secondIndexDiff = i;
                }
            }
        }
        // check if swap is possible
        return (s1.charAt(firstIndexDiff) == s2.charAt(secondIndexDiff) &&
                s1.charAt(secondIndexDiff) == s2.charAt(firstIndexDiff));
    }
}
