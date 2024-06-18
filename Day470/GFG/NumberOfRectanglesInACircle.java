//GFG
//Number of Rectangles in a Circle
//Time complexity: O(r^2)
//Space complexity: O(1)

package GFG;

public class NumberOfRectanglesInACircle {

    public static void main(String[] args) {
        int r = 2;
        System.out.println(rectanglesInCircle(r));
    }

    static int rectanglesInCircle(int r) {
        // code here
        int ans = 0;
        for (int a = 1; a <= 2 * r; ++a) {
            for (int b = 1; b <= 2 * r; ++b) {
                double ht = (double) Math.sqrt(a * a + b * b);
                if (ht <= 2 * r) {
                    ++ans;
                }
            }
        }
        return ans;
    }
}
