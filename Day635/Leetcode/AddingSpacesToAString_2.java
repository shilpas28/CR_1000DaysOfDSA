//Leetcode
//2109. Adding Spaces to a String
//Time complexity: O(N)
//Space complexity: O(N)

public class AddingSpacesToAString_2 {

    public static void main(String[] args) {
        String s = "LeetcodeHelpsMeLearn";
        int[] spaces = { 8, 13, 15 };
        System.out.println(addSpaces(s, spaces));
    }

    public static String addSpaces(String s, int[] spaces) {
        int i = 0, j = 0;
        StringBuilder res = new StringBuilder();

        while (i < s.length() && j < spaces.length) {
            if (i < spaces[j]) {
                res.append(s.charAt(i));
                i++;
            } else {
                res.append(' ');
                j++;
            }
        }

        if (i < s.length())
            res.append(s.substring(i));

        return res.toString();
    }
}
