//GFG
//AND In Range
//Time complexity: O(log l)
//Space complexity: O(1)

public class ANDInRange {

    public static void main(String[] args) {
        int l = 8, r = 13;
        System.out.println(andInRange(l, r));
    }

    public static int andInRange(int l, int r) {
        // Code here
        int shift = 0;
        // Keep shifting until l == r
        while (l < r) {
            l >>= 1;
            r >>= 1;
            shift++;
        }
        // Shift back to restore common prefix
        return l << shift;
    }
}
