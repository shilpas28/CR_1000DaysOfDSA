//Leetcode
//2516. Take K of Each Character From Left and Right - Sliding Window + Dictionary
//Time complexity: O(N)
//Space complexity: O(1)

public class TakeKOfEachCharacterFromLeftAndRight_4 {

    public static void main(String[] args) {
        String s = "aabaaaacaabc";
        int k = 2;
        System.out.println(takeCharacters(s, k));
    }

    public static int takeCharacters(String s, int k) {
        int[] d = new int[3], h = new int[3];
        for (char c : s.toCharArray())
            d[c - 'a']++;
        for (int i = 0; i < 3; i++)
            if ((d[i] -= k) < 0)
                return -1;

        int m = 0, l = 0;
        for (int r = 0; r < s.length(); r++) {
            h[s.charAt(r) - 'a']++;
            while (l <= r && h[s.charAt(r) - 'a'] > d[s.charAt(r) - 'a'])
                h[s.charAt(l++) - 'a']--;
            m = Math.max(m, r - l + 1);
        }
        return s.length() - m;
    }
}
