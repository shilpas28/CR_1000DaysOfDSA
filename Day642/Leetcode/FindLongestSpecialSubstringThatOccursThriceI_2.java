//Leetcode
//2981. Find Longest Special Substring That Occurs Thrice I - Binary Search
//Time complexity: O(NlogN)
//Space complexity: O(1)

public class FindLongestSpecialSubstringThatOccursThriceI_2 {

    public static void main(String[] args) {
        String s = "aaaa";
        System.out.println(maximumLength(s));
    }

    public static int maximumLength(String s) {
        int n = s.length();
        int l = 1, r = n;

        if (!helper(s, n, l))
            return -1;

        while (l + 1 < r) {
            int mid = (l + r) / 2;
            if (helper(s, n, mid))
                l = mid;
            else
                r = mid;
        }
        return l;
    }

    static boolean helper(String s, int n, int x) {
        int[] cnt = new int[26];
        int p = 0;

        for (int i = 0; i < n; i++) {
            while (s.charAt(p) != s.charAt(i))
                p++;
            if (i - p + 1 >= x)
                cnt[s.charAt(i) - 'a']++;
            if (cnt[s.charAt(i) - 'a'] > 2)
                return true;
        }
        return false;
    }
}
