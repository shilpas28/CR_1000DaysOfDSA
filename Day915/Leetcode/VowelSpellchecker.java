//Leetcode
//966. Vowel Spellchecker
//Time complexity: O((n + m) * k)
//Space complexity: O(n*k)

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class VowelSpellchecker {

    public static void main(String[] args) {
        String[] wordlist = { "KiTe", "kite", "hare", "Hare" };
        String[] queries = { "kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto" };
        System.out.println(Arrays.toString(spellchecker(wordlist, queries)));
    }

    public static String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exact = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> caseMap = new HashMap<>();
        Map<String, String> vowelMap = new HashMap<>();

        for (String w : wordlist) {
            String lower = toLower(w);
            String devowel = deVowel(lower);
            caseMap.putIfAbsent(lower, w);
            vowelMap.putIfAbsent(devowel, w);
        }
        
        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            if (exact.contains(q)) {
                result[i] = q;
            } else {
                String lower = toLower(q);
                String devowel = deVowel(lower);
                if (caseMap.containsKey(lower))
                    result[i] = caseMap.get(lower);
                else if (vowelMap.containsKey(devowel))
                    result[i] = vowelMap.get(devowel);
                else
                    result[i] = "";
            }
        }
        return result;
    }

    static String toLower(String s) {
        return s.toLowerCase();
    }

    static String deVowel(String s) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (isVowel(ch[i]))
                ch[i] = '*';
        }
        return new String(ch);
    }

    static boolean isVowel(char c) {
        return "aeiou".indexOf(Character.toLowerCase(c)) >= 0;
    }
}
