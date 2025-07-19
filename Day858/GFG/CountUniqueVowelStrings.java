//GFG
//Count Unique Vowel Strings
//Time complexity: O(N)
//Space complexity: O(1) 

import java.util.HashMap;

public class CountUniqueVowelStrings {

    public static void main(String[] args) {
        String s = "aeiou";
        System.out.println(vowelCount(s));
    }

    public static int vowelCount(String s) {
        // code here
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isVowel(ch)) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }
        int c = 1;
        for (char key : map.keySet()) {
            c *= map.get(key);
        }
        return fact(map.size()) * c;
    }

    static boolean isVowel(char ch) { // checking for vowel
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            return true;
        return false;
    }

    static int fact(int n) { // finding factorial
        if (n == 0)
            return 0;
        if (n == 1) {
            return 1;
        }
        return fact(n - 1) * n;
    }
}
