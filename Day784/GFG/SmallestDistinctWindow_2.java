//GFG
//Smallest distinct window
//Time complexity: O(N)
//Space complexity: O(1) 

import java.util.Arrays;

public class SmallestDistinctWindow_2 {

    public static void main(String[] args) {
        String str = "aabcbcdbca";
        System.out.println(findSubString(str));
    }

    public static int findSubString(String str) {
        // code here
        int[] freq = new int[26];
        int count = 0, uniq_count = 0;
        int subStringLength = str.length();

        for (char ch : str.toCharArray())
            freq[ch - 'a'] = 1;
        for (int i : freq)
            uniq_count += i;
        Arrays.fill(freq, 0);

        for (int right = 0, left = 0; right < str.length(); right++) {
            char char_r = str.charAt(right);

            if (freq[char_r - 'a']++ == 0)
                count++;

            while (count == uniq_count) {
                subStringLength = Math.min(subStringLength, right - left + 1);

                char char_l = str.charAt(left);
                if (--freq[char_l - 'a'] == 0) {
                    count--;
                }
                left++;
            }
        }
        return subStringLength;
    }
}
