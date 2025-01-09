//Leetcode
//2185. Counting Words With a Given Prefix - Built-In Methods 
//Time complexity: O(n*m)
//Space complexity: O(1)

public class CountingWordsWithAGivenPrefix_2 {

    public static void main(String[] args) {
        String[] words = { "pay", "attention", "practice", "attend" };
        String pref = "at";
        System.out.println(prefixCount(words, pref));
    }

    public static int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                count++; // Found a string with pref as prefix
            }
        }
        return count;
    }
}
