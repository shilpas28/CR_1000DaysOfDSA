//Leetcode
//796. Rotate String
//Time complexity: O(N^2)
//Space complexity: O(1)

public class RotateString {

    public static void main(String[] args) {
        String s = "abcde", goal = "cdeab";
        System.out.println(rotateString(s, goal));
    }

    public static boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }
}
