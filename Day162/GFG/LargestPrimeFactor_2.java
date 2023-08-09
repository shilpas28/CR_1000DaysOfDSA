//GFG
//Largest prime factor - Optimal solution
//Time complexity: O(sqrt(N))
//Space complexity: O(1) 

package GFG;

public class LargestPrimeFactor_2 {

    public static void main(String[] args) {
        int N = 5;
        System.out.println(largestPrimeFactor(N));
    }

    static long largestPrimeFactor(int N) {
        // code here
        long st = 2;
        while (st * st <= N) {
            if (N % st == 0)
                N /= st;
            else
                st++;
        }
        return N;
    }
}
