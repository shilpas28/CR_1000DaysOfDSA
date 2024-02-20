//GFG
//Word Break
//Time complexity: O(len(s)^2)
//Space complexity: O(len(s))

package GFG;

import java.util.ArrayList;

public class WordBreak_3 {

    public static void main(String[] args) {

        int n = 6;
        // B = { "i", "like", "sam", "sung", "samsung", "mobile"}
        ArrayList<String> B = new ArrayList<>();
        B.add("i");
        B.add("like");
        B.add("sam");
        B.add("sung");
        B.add("Samsung");
        B.add("mobile");
        String A = "ilike";
        System.out.println(wordBreak(n, A, B));
    }

    public static int wordBreak(int n, String s, ArrayList<String> dictionary) {
        // code here
        boolean ans = help(s, dictionary, 0);
        return ans == true ? 1 : 0;
    }

    static boolean help(String A, ArrayList<String> B, int index) {
        if (index == A.length())
            return true;
        String temp = "";
        boolean a = false;
        for (int i = index; i < A.length(); i++) {
            temp += A.charAt(i);
            if (B.contains(temp) == true) {
                a = a | help(A, B, i + 1);
            }
        }
        return a;
    }
}
