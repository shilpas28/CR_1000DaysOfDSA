//Leetcode
//2390. Removing Stars From a String - without the use of Stack
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

public class RemovingStarsFromAString_1 {
    public static void main(String[] args) {
        String s = "leet**cod*e";
        System.out.println(removeStars(s));
    }

    public static String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '*')
                sb.setLength(sb.length() - 1);
            else
                sb.append(c);
        }
        return sb.toString();
    }
}
