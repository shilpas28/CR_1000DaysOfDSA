//Leetcode
//648. Replace Words
//Time complexity: O(n * m * m) where n is the number of words in the sentence string and m is the length of longest word in the 
//sentence string.
//Space complexity: O(n * m) where n is the number of words in the sentence string and m is the length of longest word 
//in the sentence string.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReplaceWords {

    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(replaceWords(dictionary, sentence));
    }

    public static String replaceWords(List<String> dictionary, String sentence) {
        Set<String> s = new HashSet<>(dictionary);
        StringBuilder res = new StringBuilder();
        List<String> temp = new ArrayList<>(
                Arrays.asList(sentence.split(" ")));

        for (String t : temp) {
            int i = 0;
            while (i <= t.length()) {
                String curr = t.substring(0, i++);
                if (s.contains(curr)) {
                    res.append(curr).append(" ");
                    break;
                }

                if (i == t.length() + 1)
                    res.append(t).append(" ");
            }
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
}
