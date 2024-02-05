//Leetcode
//387. First Unique Character in a String
//Time complexity: O(N^2)
//Space complexity: O(1)

package Leetcode;

public class FirstUniqueCharacterInAString {

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if (i == s.lastIndexOf(c) && i == s.indexOf(c))
                return i;
        }
        return -1;
    }
}
