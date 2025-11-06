//GFG
//Ways To Tile A Floor
//Time complexity: O(N)
//Space complexity: O(1) 

public class WaysToTileAFloor {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(numberOfWays(n));
    }

    public static int numberOfWays(int n) {
        // code here
        int cur = 1;
        int prev = 1;
        int sum = 1;
        for (int i = 1; i < n; i++) {
            sum = cur + prev;
            prev = cur;
            cur = sum;
        }
        return sum;
    }
}
