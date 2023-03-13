//GFG
//Maximum Possible Value
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class MaximumPossibleValue {

    public static void main(String[] args) {
        int N = 4;
        int A[] = { 3, 4, 6, 5 };
        int B[] = { 2, 3, 1, 6 };
        System.out.println(maxPossibleValue(N, A, B));
    }

    public static long maxPossibleValue(int N, int A[], int B[]) {
        // code here
        long min_len = Integer.MAX_VALUE;
        long tot_stick = 0;
        long tot_peri = 0;
        for (int i = 0; i < N; i++) {
            if (B[i] % 2 == 1)
                B[i]--;
            if (B[i] >= 2)
                min_len = Math.min(min_len, A[i]);

            tot_stick += B[i];
            tot_peri += B[i] * A[i];
        }
        if (tot_stick % 4 != 0) // even number not div by 4 also results rem==2
            tot_peri -= 2 * min_len;

        return tot_peri;
    }

}
