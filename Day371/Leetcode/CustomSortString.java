//Leetcode
//791. Custom Sort String
//Time complexity: O(n+m), where nnn is the length of the string s and mis the length of the string order. This is because we 
//iterate through each string exactly once. The final iteration through the 26 possible characters is constant time, O(1), in 
//the context of this problem's constraints.
//Space complexity: O(1), since the frequency array map uses constant space, irrespective of the input size. The size of the 
//StringBuilder does not count towards space complexity as it is required for the output.

package Leetcode;

public class CustomSortString {

    public static void main(String[] args) {
        String order = "cba", s = "abcd";
        System.out.println(customSortString(order, s));
    }

    public static String customSortString(String order, String s) {
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            for (int j = 0; j < map[order.charAt(i) - 'a']; j++) {
                result.append(order.charAt(i));
            }
            map[order.charAt(i) - 'a'] = 0;
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < map[i]; j++) {
                result.append((char) ('a' + i));
            }
        }
        return result.toString();
    }
}
