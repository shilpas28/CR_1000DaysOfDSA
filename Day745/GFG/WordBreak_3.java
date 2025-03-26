//GFG
//Word Break - Not accepted as TLE
//Time complexity: O(len(s)^2)
//Space complexity: O(len(s))

public class WordBreak_3 {

    public static void main(String[] args) {
        String s = "ilike";
        String dictionary[] = { "i", "like", "gfg" };
        System.out.println(wordBreak(s, dictionary));
    }

    public static int wordBreak(String s, String[] dictionary) {
        // code here
        boolean ans = help(s, dictionary, 0);
        return ans == true ? 1 : 0;
    }

    static boolean help(String A, String[] B, int index) {
        if (index == A.length())
            return true;
        String temp = "";
        boolean a = false;
        for (int i = index; i < A.length(); i++) {
            temp += A.charAt(i);
            if (contains(B, temp)) {
                a = a | help(A, B, i + 1);
            }
        }
        return a;
    }

    static boolean contains(String[] B, String word) {
        for (String str : B) {
            if (str.equals(word)) {
                return true;
            }
        }
        return false;
    }
}
