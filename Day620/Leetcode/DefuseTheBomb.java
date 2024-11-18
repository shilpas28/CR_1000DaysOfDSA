//Leetcode
//1652. Defuse the Bomb
//Time complexity: O(N^2)
//Space complexity: O(1)

import java.util.Arrays;

public class DefuseTheBomb {

    public static void main(String[] args) {
        int[] code = { 5, 7, 1, 4 };
        int k = 3;
        System.out.println(Arrays.toString(decrypt(code, k)));
    }

    public static int[] decrypt(int[] code, int k) {
        if (k == 0) {
            Arrays.fill(code, 0);
            return code;
        }

        int length = code.length, sum = 0;
        int[] decode = new int[length];

        for (int i = 0; i < length; i += 1) {
            for (int j = 1; j <= Math.abs(k); j += 1) {
                int exp1 = ((i + j) + length) % length;
                int exp2 = ((i - j) + length) % length;
                int index = k > 0 ? exp1 : exp2;
                sum += code[index];
            }
            decode[i] = sum;
            sum = 0;
        }
        return decode;
    }
}
