//Leetcode
//3335. Total Characters in String After Transformations I
//Time complexity: 0(T*26)
//Space complexity: 0(26)

public class TotalCharactersInStringAfterTransformationsI {

    public static void main(String[] args) {
        String s = "abcyy";
        int t = 2;
        System.out.println(lengthAfterTransformations(s, t));
    }

    public static int lengthAfterTransformations(String s, int t) {
        final int MOD = 1000000007;
        long[] cnt = new long[26];

        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        for (int j = 0; j < t; j++) {
            long[] tmp = new long[26];
            for (int i = 0; i < 26; i++) {
                if (i == 25) {
                    tmp[0] = (tmp[0] + cnt[i]) % MOD;
                    tmp[1] = (tmp[1] + cnt[i]) % MOD;
                } else {
                    tmp[i + 1] = (tmp[i + 1] + cnt[i]) % MOD;
                }
            }
            cnt = tmp;
        }

        long len = 0;
        for (long c : cnt) {
            len = (len + c) % MOD;
        }

        return (int) len;
    }
}
