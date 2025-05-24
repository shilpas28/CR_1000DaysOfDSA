//Leetcode
//2942. Find Words Containing Character - Using find
//Time complexity: O(N*M) where n is the number of words and m is the average length of each word, 
//due to the search operation within each string.
//Space complexity: O(k) where k is the number of words that contain the character x.

import java.util.ArrayList;
import java.util.List;

public class FindWordsContainingCharacter_2 {

    public static void main(String[] args) {
        String[] words = { "leet", "code" };
        char x = 'e';
        System.out.println(findWordsContaining(words, x));
    }

    public static List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) != -1)
                res.add(i);
        }
        return res;
    }
}
