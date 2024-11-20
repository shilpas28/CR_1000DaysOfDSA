//Leetcode
//2516. Take K of Each Character From Left and Right - Sliding Window
//Time complexity: O(N)
//Space complexity: O(1)

public class TakeKOfEachCharacterFromLeftAndRight {

    public static void main(String[] args) {
        String s = "aabaaaacaabc";
        int k = 2;
        System.out.println(takeCharacters(s, k));
    }

    public static int takeCharacters(String s, int k) {
        int[] count = new int[3];
        for (char c : s.toCharArray())
            count[c - 'a']++;

        if (Math.min(Math.min(count[0], count[1]), count[2]) < k)
            return -1;

        // Sliding Window
        int res = Integer.MAX_VALUE;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            count[s.charAt(r) - 'a']--;

            while (Math.min(Math.min(count[0], count[1]), count[2]) < k) {
                count[s.charAt(l) - 'a']++;
                l++;
            }
            res = Math.min(res, s.length() - (r - l + 1));
        }
        return res;
    }
}
