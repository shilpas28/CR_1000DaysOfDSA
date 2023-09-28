//GFG
//Wave Array
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class WaveArray {

    public static void main(String[] args) {
        int n = 6;
        int[] arr = { 2, 4, 7, 8, 9, 10 };
        convertToWave(n, arr);
        for (int val : arr) {
            System.out.print(val + " ");
        }
    }

    public static void convertToWave(int n, int[] a) {
        // code here
        for (int i = 1; i < n; i += 2) {
            int c = a[i];
            a[i] = a[i - 1];
            a[i - 1] = c;
        }
    }
}
