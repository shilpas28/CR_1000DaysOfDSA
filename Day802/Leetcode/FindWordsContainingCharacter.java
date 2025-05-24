//Leetcode
//2942. Find Words Containing Character - Brute Force
//Time complexity: O(N^2)
//Space complexity: O(N) 

import java.util.ArrayList;
import java.util.List;

public class FindWordsContainingCharacter {

    public static void main(String[] args) {
        String[] words = { "leet", "code" };
        char x = 'e';
        System.out.println(findWordsContaining(words, x));
    }

    public static List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (char ch : words[i].toCharArray()) {
                if (ch == x) {
                    res.add(i);
                    break;
                }
            }
        }
        return res;
    }
}
