//GFG
//Cutting Rectangles - Recursive solution
//Time complexity: O(log min(L,B))
//Space complexity:  O(1)

package GFG;

import java.util.Arrays;
import java.util.List;

public class CuttingRectangles_2 {
    
    public static void main(String[] args) {
        long L = 2, B = 4;
        System.out.println(minimumSquares(L, B));
    }

    static List<Long> minimumSquares(long L, long B) {

        long K = gcd(L, B);
        long N = (long) (L * B) / (long) (K * K);
        return Arrays.asList(N, K);
    }

    static long gcd(long a,long b)
    {
        if(a<b) return gcd(b,a);
        if(b==0) return a;   
        return gcd(b,a%b);
    }
}
