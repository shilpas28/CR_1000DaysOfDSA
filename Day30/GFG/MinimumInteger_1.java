//GFG  
//Minimum Integer
//Time complexity: O(N)
//Space complexity: O(1)

public class MinimumInteger_1 {

    public static void main(String[] args) {
        int N = 3;
        int[] A = { 1, 3, 2 };
        System.out.println(minimumInteger(N, A));
    }

    public static int minimumInteger(int N, int[] A) {
        // code here
        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += A[i];
        }
        long min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if ((Math.log(sum) <= Math.log(N) + Math.log(A[i]))) { //log ab = log a + log b
                min = Math.min(min, A[i]);
            }
        }
        return (int) min;
    }
}
