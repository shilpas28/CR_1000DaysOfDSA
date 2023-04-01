//GFG - Brute force method - this method is nto accepted as TLE 
//Make Array Elements Equal
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class MakeArrayElementsEqual {

    public static void main(String[] args) {
        int N = 3;
        System.out.println(minOperations(N));
    }

    public static long minOperations(int N) {
        // Code here
        int medIndex = N % 2 == 0 ? N / 2 : N / 2;
        int median = N % 2 == 0 ? medIndex * 2 + 1 : medIndex * 2;

        int ans = 0;
        for (int i = 0; i < N; i++) {
            int el = i * 2 + 1;
            ans += Math.abs(el - median);
        }
        return ans / 2;
    }
}
