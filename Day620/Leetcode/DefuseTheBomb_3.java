//Leetcode
//1652. Defuse the Bomb
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.Arrays;

public class DefuseTheBomb_3 {

    public static void main(String[] args) {
        int[] code = { 5, 7, 1, 4 };
        int k = 3;
        System.out.println(Arrays.toString(decrypt(code, k)));
    }

    public static int[] decrypt(int[] code, int k) {
        int[] res = new int[code.length];
        if (k == 0)
            return res;
        // Define the initial window and initial sum
        int start = 1, end = k, sum = 0;
        if (k < 0) {// If k < 0, the starting point will be end of the array.
            k = -k;
            start = code.length - k;
            end = code.length - 1;
        }
        for (int i = start; i <= end; i++)
            sum += code[i];
        // Scan through the code array as i moving to the right, update the window sum.
        for (int i = 0; i < code.length; i++) {
            res[i] = sum;
            sum -= code[(start++) % code.length];
            sum += code[(++end) % code.length];
        }
        return res;
    }
}
