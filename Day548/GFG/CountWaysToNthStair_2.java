//GFG
//Count ways to N'th Stair(Order does not matter)
//Time complexity: O(n)
//Space complexity: O(1)

public class CountWaysToNthStair_2 {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(nthStair(n));
    }

    public static long nthStair(int n) {
        // Code here
        int ans = 0;
        if (n % 2 == 0) {
            while (n > 0) {
                ans += 1;
                n -= 2;
            }
            return ans + 1;
        }
        while (n > 0) {
            ans += 1;
            n -= 2;
        }
        return ans;
    }
}
