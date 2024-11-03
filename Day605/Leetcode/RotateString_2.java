//Leetcode
//796. Rotate String
//Time complexity: O(N)
//Space complexity: O(1)

public class RotateString_2 {

    public static void main(String[] args) {
        String s = "abcde", goal = "cdeab";
        System.out.println(rotateString(s, goal));
    }

    public static boolean rotateString(String s, String goal) {
        if (s == null || goal == null)
            // throw exception on A and B both being null?
            return false;

        if (s.length() != goal.length())
            return false;

        if (s.length() == 0)
            return true;

        for (int i = 0; i < s.length(); i++)
            if (rotateString(s, goal, i))
                return true;

        return false;
    }

    static boolean rotateString(String A, String B, int rotation) {
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt((i + rotation) % B.length())) {
                return false;
            }
        }
        return true;
    }
}
