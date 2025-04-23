//GFG
//Unique Number II
//Time complexity: O(N)
//Space complexity: O(1) 

import java.util.Arrays;

public class UniqueNumberII_2 {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 2, 1, 4 };
        System.out.println(Arrays.toString(singleNum(arr)));
    }

    public static int[] singleNum(int[] arr) {
        // Code here
        int xor = 0;
        for (int i : arr)
            xor ^= i;
        int bitMask = xor & -xor;
        int x = 0, y = 0;
        for (int i : arr) {
            if ((i & bitMask) == 0)
                x ^= i;
            else
                y ^= i;
        }

        return new int[] { Math.min(x, y), Math.max(x, y) };
    }
}
