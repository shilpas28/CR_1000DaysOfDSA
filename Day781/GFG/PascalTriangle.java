//GFG
//Pascal Triangle
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.ArrayList;

public class PascalTriangle {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(nthRowOfPascalTriangle(n));
    }

    static ArrayList<Integer> nthRowOfPascalTriangle(int n) {
        // code here
        int mod = 1000000007;
        ArrayList<Integer> al = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            al.add(0); // Initialize each element to 0L
        }
        al.set(0, 1);
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j >= 1; j--) {
                al.set(j, (al.get(j) % mod + al.get(j - 1) % mod) % mod);
            }
        }
        return al;
    }
}
