//Leetcode
//1002. Find Common Characters
//Time complexity: O(N)
//Space complexity: O(1)

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters_2 {

    public static void main(String[] args) {
        String[] words = { "bella", "label", "roller" };
        System.out.println(commonChars(words));
    }

    public static List<String> commonChars(String[] words) {
        int[] last = count(words[0]);
        for (int i = 1; i < words.length; i++) {
            last = intersection(last, count(words[i]));
        }
        List<String> arr = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (last[i] != 0) {
                char a = 'a';
                a += i;
                String s = String.valueOf(a);
                while (last[i] > 0) {
                    arr.add(s);
                    last[i]--;
                }
            }
        }
        return arr;
    }

    static int[] intersection(int[] a, int[] b) {
        int[] t = new int[26];
        for (int i = 0; i < 26; i++) {
            t[i] = Math.min(a[i], b[i]);
        }
        return t;
    }

    static int[] count(String str) {
        int[] t = new int[26];
        for (char c : str.toCharArray())
            t[c - 'a']++;
        return t;
    }
}
