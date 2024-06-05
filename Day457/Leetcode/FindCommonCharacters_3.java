//Leetcode
//1002. Find Common Characters
//Time complexity: O(N)
//Space complexity: O(1)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class FindCommonCharacters_3 {

    public static void main(String[] args) {
        String[] words = { "bella", "label", "roller" };
        System.out.println(commonChars(words));
    }

    public static List<String> commonChars(String[] words) {
        int[] count = new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);
        for (String str : words) {
            int[] cnt = new int[26];
            str.chars().forEach(c -> ++cnt[c - 'a']); // count each char's frequency in string str.
            IntStream.range(0, 26).forEach(i -> count[i] = Math.min(cnt[i], count[i])); // update minimum frequency.
        }
        List<String> ans = new ArrayList<>();
        IntStream.range('a', 'z' + 1).forEach(c -> ans.addAll(Collections.nCopies(count[c - 'a'], "" + (char) c)));
        return ans;
    }
}
