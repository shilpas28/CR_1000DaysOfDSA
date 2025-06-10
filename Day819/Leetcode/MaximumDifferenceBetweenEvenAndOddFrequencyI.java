//Leetcode
//3442. Maximum Difference Between Even and Odd Frequency I
//Time complexity: O(NlogN)
//Space complexity: O(1) 

import java.util.Arrays;

public class MaximumDifferenceBetweenEvenAndOddFrequencyI {

    public static void main(String[] args) {
        String s = "aaaaabbc";
        System.out.println(maxDifference(s));
    }

    public static int maxDifference(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        int mxOdd = 0, minEven = Integer.MAX_VALUE;
        char cur = chars[0];
        int cnt = 1;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == cur) {
                cnt++;
            } else {
                if ((cnt & 1) == 1) {
                    mxOdd = Math.max(mxOdd, cnt);
                } else {
                    minEven = Math.min(minEven, cnt);
                }
                cur = chars[i];
                cnt = 1;
            }
        }

        // For the last character
        if ((cnt & 1) == 1) {
            mxOdd = Math.max(mxOdd, cnt);
        } else {
            minEven = Math.min(minEven, cnt);
        }

        return mxOdd - minEven;
    }
}
