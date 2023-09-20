//GFG
//Rotate Bits
//Time complexity: O(1)
//Space complexity: O(1)

package GFG;

import java.util.ArrayList;

public class RotateBits {

    public static void main(String[] args) {
        int n = 28, d = 2;
        System.out.println(rotate(n, d));
    }

    static ArrayList<Integer> rotate(int N, int D) {
        // your code here
        ArrayList<Integer> list = new ArrayList<>();
        D = D % 16;
        int l = (N << D | N >> (16 - D)) & 65535;
        int r = (N >> D | N << (16 - D)) & 65535;
        list.add(l);
        list.add(r);
        return list;
    }
}
