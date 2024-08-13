//GFG
//Square root of a number
//Time complexity: O(logN)
//Space complexity: O(1)

public class SquareRootOfANumber {

    public static void main(String[] args) {
        long n = 5;
        System.out.println(floorSqrt(n));
    }

    static long floorSqrt(long n) {
        // Your code here
        long low = 1, high = n, ans = 1, mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (mid * mid == n)
                return mid;
            else if (mid * mid < n) {
                low = mid + 1;
                ans = mid;
            } else
                high = mid - 1;
        }
        return ans;
    }
}
