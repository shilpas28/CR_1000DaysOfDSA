//Leetcode
//1220. Count Vowels Permutation - Recursive Approach - Not accepted as TLE
//Time complexity: O(6^(5 * N))
//Space complexity: O(N)

package Leetcode;

public class CountVowelsPermutation {

    public static void main(String[] args) {
        int n = 1;
        System.out.println(countVowelPermutation(n));
    }

    public static int countVowelPermutation(int n) {
        return (int) findPerm(n, 0);
    }

    static long MOD = (long)(1e9 + 7);
    static long findPerm(int len, int last) {
        if (len == 0)
            return 1;

        long count = 0;
        if (last == 2)
            count = (count + findPerm(len - 1, 1)) % MOD;
        if (last == 1 || last == 3)
            count = (count + findPerm(len - 1, 2)) % MOD;
        if (last != 0 && last != 3)
            count = (count + findPerm(len - 1, 3)) % MOD;
        if (last == 3 || last == 5)
            count = (count + findPerm(len - 1, 4)) % MOD;
        if (last == 1)
            count = (count + findPerm(len - 1, 5)) % MOD;
        if (last == 0)
            for (int i = 1; i <= 5; i++)
                count = (count + findPerm(len - 1, i)) % MOD;

        return count % MOD;
    }
}
