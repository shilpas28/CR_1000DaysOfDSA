//Leetcode
//1897. Redistribute Characters to Make All Strings Equal - Using Vector
//Time complexity: O(n.k)
//Space complexity: O(1) 

package Leetcode;

public class RedistributeCharactersToMakeAllStringsEqual {

    public static void main(String[] args) {
        String[] words = { "abc", "aabc", "bc" };
        System.out.println(makeEqual(words));
    }

    public static boolean makeEqual(String[] words) {

        int[] counts = new int[26];
        for (String word : words) {
            for (char c : word.toCharArray()) {
                counts[c - 'a']++;
            }
        }
        int n = words.length;
        for (int val : counts) {
            if (val % n != 0) {
                return false;
            }
        }
        return true;
    }
}
