//GFG
//Maximum product subset of an array
//Time complexity: O(N)
//Space complexity: O(1)

import java.util.ArrayList;
import java.util.List;

public class MaximumProductSubsetOfAnArray {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(-1);
        arr.add(0);
        arr.add(-2);
        arr.add(4);
        arr.add(3);
        System.out.println(findMaxProduct(arr));
    }

    public static long findMaxProduct(List<Integer> arr) {
        // code here
        if (arr.size() == 1)
            return arr.get(0);
        long pos = 1, neg = 1, negLar = Long.MIN_VALUE, mod = 1000000007, c1 = 0, c2 = 0;
        for (Integer x : arr) {
            if (x < 0) {
                neg = (neg * (long) x) % mod;
                ;
                negLar = Math.max((long) x, negLar);
                c1++;
            }
            if (x > 0) {
                pos = (pos * (long) x) % mod;
                c2++;
            }
        }
        if (c1 <= 1 && c2 == 0)
            return 0;
        if (neg < 0)
            neg /= negLar;
        return (pos * neg) % mod;
    }
}
