//Leetcode
//1239. Maximum Length of a Concatenated String with Unique Characters - Bit Operation
//Time complexity: O(N * M) - where N is the number of strings in the array and M is the maximum length of a string in the array.
//Space complexity: O(2^M) - where M is the maximum length of a string. The dp list can have up to 2^M elements.

package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {

    public static void main(String[] args) {

        List<String> arr = new ArrayList<String>();
        arr.add("un");
        arr.add("iq");
        arr.add("ue");
        System.out.println(maxLength(arr));
    }

    public static int maxLength(List<String> arr) {
        List<Integer> dp = new ArrayList<>();
        dp.add(0);
        int res = 0;
        for (String s : arr) {
            int a = 0, dup = 0;
            for (char c : s.toCharArray()) {
                dup |= a & (1 << (c - 'a'));
                a |= 1 << (c - 'a');
            }
            if (dup > 0)
                continue;
            for (int i = dp.size() - 1; i >= 0; i--) {
                if ((dp.get(i) & a) > 0)
                    continue;
                dp.add(dp.get(i) | a);
                res = Math.max(res, Integer.bitCount(dp.get(i) | a));
            }
        }
        return res;
    }
}
