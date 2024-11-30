//GFG
//Anagram
//Time complexity: O(n+m)
//Space complexity: O(1) 

public class Anagram {

    public static void main(String[] args) {
        String s1 = "geeks", s2 = "kseeg";
        System.out.println(areAnagrams(s1, s2));
    }

    // Function is to check whether two strings are anagram of each other or not.
    public static boolean areAnagrams(String s1, String s2) {

        // Your code here
        int[] arr = new int[26];
        for (char c : s1.toCharArray())
            ++arr[c - 'a'];

        for (char c : s2.toCharArray())
            --arr[c - 'a'];

        for (int freq : arr) {
            if (freq != 0) {
                return false;
            }
        }
        return true;
    }
}
