//GFG
//Max sum in the configuration
//Time complexity: O(N)
//Space complexity: O(1)

public class MaxSumInTheConfiguration {

    public static void main(String[] args) {
        int n = 4;
        int a[] = { 8, 3, 1, 2 };
        System.out.println(max_sum(a, n));
    }

    static long max_sum(int a[], int n) {
        // Your code here
        long cum_sum = 0;
        for (int i = 0; i < n; i++)
            cum_sum += a[i];

        long initial_val = 0;
        long max = 0;

        for (int i = 0; i < n; i++) {
            initial_val += (long) i * a[i];
            max = initial_val;
        }

        for (int i = 1; i < n; i++) {
            long temp = initial_val - (cum_sum - a[i - 1]) + (long) a[i - 1] * (n - 1);
            initial_val = temp;
            if (temp > max)
                max = temp;
        }
        return max;
    }
}
