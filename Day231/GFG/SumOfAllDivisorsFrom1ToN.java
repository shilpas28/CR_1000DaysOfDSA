//GFG
//Sum of all divisors from 1 to n
//Time complexity: O(N)
//Space complexity: O(1) 

package GFG;

public class SumOfAllDivisorsFrom1ToN {

    public static void main(String[] args) {
        int N = 4;
        System.out.println(sumOfDivisors(N));
    }

    static long sumOfDivisors(int N) {
        // code here
        long sum = 0;
        for (int i = 1; i <= N; i++)
            sum += i * (N / i);
        return sum;
    }
}
