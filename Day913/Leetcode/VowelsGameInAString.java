//Leetcode
//3227. Vowels Game in a String
//Time complexity: O(N)
//Space complexity: O(1)

public class VowelsGameInAString {

    public static void main(String[] args) {
        String s = "leetcoder";
        System.out.println(doesAliceWin(s));
    }

    public static boolean doesAliceWin(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return true;
            }
        }
        return false;
    }
}
