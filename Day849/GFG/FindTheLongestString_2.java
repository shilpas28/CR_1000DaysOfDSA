//GFG
//Find the longest string
//Time complexity: O(n * max(arr[i].size()) )
//Space complexity: O(n * max(arr[i].size()) )

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindTheLongestString_2 {

    public static void main(String[] args) {
        String arr[] = { "p", "pr", "pro", "probl", "problem", "pros", "process", "processor" };
        System.out.println(longestString(arr));
    }

    public static String longestString(String[] arr) {
        // code here
        // Sort by length ascending, then lexicographically
        Arrays.sort(arr, (a, b) -> {
            if (a.length() == b.length())
                return a.compareTo(b);
            return a.length() - b.length();
        });

        Set<String> set = new HashSet<>();
        String answer = "";

        for (String word : arr) {
            // If word is 1 char or its immediate prefix is valid
            if (word.length() == 1 || set.contains(word.substring(0, word.length() - 1))) {
                set.add(word);
                if (word.length() > answer.length() ||
                        (word.length() == answer.length() && word.compareTo(answer) < 0)) {
                    answer = word;
                }
            }
        }

        return answer.isEmpty() ? "-1" : answer;
    }
}
