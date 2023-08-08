//GFG - Not accepted as TLE
//Fraction pairs with sum 1
//Time complexity: O(N^2)
//Space complexity: O(1) 

package GFG;

public class FractionPairsWithSum1 {

    public static void main(String[] args) {
        int N = 4;
        int[] numerator = { 1, 2, 2, 8 };
        int[] denominator = { 2, 4, 6, 12 };
        System.out.println(countFractions(N, numerator, denominator));
    }

    public static int countFractions(int n, int[] numerator, int[] denominator) {
        // code here
        int count = 0;
        for (int i = 0; i < n; i++) {
            double n1 = (double) numerator[i] / denominator[i];
            for (int j = i + 1; j < n; j++) {
                double n2 = (double) numerator[j] / denominator[j];
                if (n1 + n2 == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
