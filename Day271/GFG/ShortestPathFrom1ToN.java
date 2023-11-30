//GFG
//Shortest path from 1 to n
//Time complexity: O(logN)
//Space complexity: O(1)

public class ShortestPathFrom1ToN {

    public static void main(String[] args) {
        int n = 9;
        System.out.println(minStep(n));
    }

    public static int minStep(int n) {
        // code here
        int ans = 0;
        while (n > 1) {
            if (n % 3 == 0)
                n /= 3;
            else
                n--;
            ans++;
        }
        return ans;
    }
}
