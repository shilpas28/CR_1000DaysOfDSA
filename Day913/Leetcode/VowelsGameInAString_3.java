//Leetcode
//3227. Vowels Game in a String
//Time complexity: O(N)
//Space complexity: O(1)

public class VowelsGameInAString_3 {

    public static void main(String[] args) {
        String s = "leetcoder";
        System.out.println(doesAliceWin(s));
    }

    public static boolean doesAliceWin(String s) {
        for (int i = 0; i < s.length(); i++)
            if ((0x104111 >> (s.charAt(i) - 97) & 1) != 0)
                return true;
        return false;
    }
}
