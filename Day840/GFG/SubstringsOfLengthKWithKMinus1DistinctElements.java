//GFG
//Substrings of length k with k-1 distinct elements
//Time complexity: O(N)
//Space complexity: O(1) 

import java.util.HashMap;

public class SubstringsOfLengthKWithKMinus1DistinctElements {

    public static void main(String[] args) {
        String s = "abcc";
        int k = 2;
        System.out.println(substrCount(s, k));
    }

    public static int substrCount(String s, int k) {
        // code here
        if (s.length() < k)
            return 0;

        int count = 0;
        for (int i = 0; i <= s.length() - k; i++) {
            String sub = s.substring(i, i + k);
            HashMap<Character, Integer> map = new HashMap<>();

            for (char c : sub.toCharArray())
                map.put(c, map.getOrDefault(c, 0) + 1);

            if (map.size() == k - 1)
                count++;
        }
        return count;
    }
}
