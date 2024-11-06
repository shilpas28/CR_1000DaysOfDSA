//Leetcode
//3011. Find if Array Can Be Sorted
//Time complexity: O(N)
//Space complexity: O(1) 

public class FindIfArrayCanBeSorted_2 {

    public static void main(String[] args) {
        int[] nums = { 8, 4, 2, 30, 15 };
        System.out.println(canSortArray(nums));
    }

    public static boolean canSortArray(int[] nums) {
        short pmax = 0, cmin = 0, cmax = 0;
        byte pcnt = 0;
        for (final int v : nums) {
            final byte ccnt = (byte) Integer.bitCount(v);
            if (pcnt == ccnt) {
                cmin = cmin > v ? (short) v : cmin;
                cmax = cmax < v ? (short) v : cmax;
            } else if (cmin < pmax) {
                return false;
            } else {
                pmax = cmax;
                cmin = cmax = (short) v;
                pcnt = ccnt;
            }
        }
        return cmin >= pmax;
    }
}
