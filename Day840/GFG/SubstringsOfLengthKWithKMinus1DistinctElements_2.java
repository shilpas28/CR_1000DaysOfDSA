//GFG
//Substrings of length k with k-1 distinct elements
//Time complexity: O(N)
//Space complexity: O(1) 

import java.util.HashSet;
import java.util.Set;

public class SubstringsOfLengthKWithKMinus1DistinctElements_2 {

    public static void main(String[] args) {
        String s = "abcc";
        int k = 2;
        System.out.println(substrCount(s, k));
    }

    public static int substrCount(String s, int k) {
        // code here
        char[] arr = s.toCharArray();
        int count = 0;
        for (int i = 0; i <= arr.length - k; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < i + k; j++)
                set.add(arr[j]);
            if (set.size() == k - 1)
                count++;
        }
        return count;
    }
}
