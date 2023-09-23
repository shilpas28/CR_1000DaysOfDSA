//GFG - Optimal method
//Equilibrium Point
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class EquilibriumPoint_2 {

    public static void main(String[] args) {
        int n = 5;
        long A[] = { 1, 3, 5, 2, 2 };
        System.out.println(equilibriumPoint(A, n));
    }

    // a: input array
    // n: size of array
    // Function to find equilibrium point in the array.
    public static int equilibriumPoint(long arr[], int n) {

        // Your code here
        if (n == 1)
            return 1;
        long s1 = arr[0], s2 = arr[n - 1];
        int i = 1, j = n - 2;

        while (i <= j) {
            if (s1 == s2 && i == j)
                return i + 1;
            if (s1 < s2)
                s1 += arr[i++];
            else
                s2 += arr[j--];
        }

        return -1;
    }
}
