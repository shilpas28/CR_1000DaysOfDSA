//Leetcode
//2109. Adding Spaces to a String
//Time complexity: O(N)
//Space complexity: O(N)

public class AddingSpacesToAString {

    public static void main(String[] args) {
        String s = "LeetcodeHelpsMeLearn";
        int[] spaces = { 8, 13, 15 };
        System.out.println(addSpaces(s, spaces));
    }

    public static String addSpaces(String s, int[] spaces) {
        char[] result = new char[s.length() + spaces.length];
        int writePos = 0;
        int readPos = 0;

        for (int spacePos : spaces) {
            while (readPos < spacePos) {
                result[writePos++] = s.charAt(readPos++);
            }
            result[writePos++] = ' ';
        }

        while (readPos < s.length())
            result[writePos++] = s.charAt(readPos++);

        return new String(result);
    }
}
