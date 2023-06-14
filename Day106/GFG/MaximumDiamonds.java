//GFG - Not accepted as TLE
//Maximum Diamonds
//Time complexity: O(K*NlogN)
//Space complexity: O(1)

package GFG;

import java.util.Arrays;

public class MaximumDiamonds {

    public static void main(String[] args) {
        int N = 5, K = 3;
        int A[] = { 2, 1, 7, 4, 2 };
        System.out.println(maxDiamonds(A, N, K));
    }

    static long maxDiamonds(int[] A, int N, int K) {
        // code here
        long ans=0;
        for(int i=0; i<K; i++)
        {
            Arrays.sort(A);
            ans+= A[N-1];
            A[N-1]= A[N-1]/2;
        }
        return ans;
    }
}
