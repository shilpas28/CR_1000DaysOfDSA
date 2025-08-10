//Leetcode
//869. Reordered Power of 2
//Time complexity: O(NlogN)
//Space complexity: O(N) 

import java.util.Arrays;

public class ReorderedPowerOf2 {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(reorderedPowerOf2(n));
    }

    public static boolean reorderedPowerOf2(int n) {
        char[] a1 = String.valueOf(n).toCharArray();
        Arrays.sort(a1);
        String s1 = new String(a1);

        for (int i = 0; i < 31; i++) {
            char[] a2 = String.valueOf((int) (1 << i)).toCharArray();
            Arrays.sort(a2);
            String s2 = new String(a2);
            if (s1.equals(s2))
                return true;
        }

        return false;
    }
}
