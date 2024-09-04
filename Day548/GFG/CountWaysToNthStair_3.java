//GFG
//Count ways to N'th Stair(Order does not matter)
//Time complexity: O(1)
//Space complexity: O(1)

public class CountWaysToNthStair_3 {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(nthStair(n));
    }

    public static long nthStair(int n) {
        // Code here
        return n / 2 + 1;
    }
}
