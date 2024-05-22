//Leetcode
//131. Palindrome Partitioning
//Time complexity: O( (2^n) *k*(n/2) ) - O(2^n) to generate every substring and O(n/2)  to check if the substring 
//generated is a palindrome. O(k) is for inserting the palindromes in another data structure, where k  is the 
//average length of the palindrome list.
//Space complexity: O(k * x) - The space complexity can vary depending upon the length of the answer. 
//k is the average length of the list of palindromes and if we have x such list of palindromes in our final answer. 
//The depth of the recursion tree is n, so the auxiliary space required is equal to the O(n).

package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        partitionHelper(0, s, path, res);
        return res;
    }

    static void partitionHelper(int index, String s, List<String> path, List<List<String>> res) {
        if (index == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < s.length(); ++i) {
            if (isPalindrome(s, index, i)) {
                path.add(s.substring(index, i + 1));
                partitionHelper(i + 1, s, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    static boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}
