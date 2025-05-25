//GFG
//Pythagorean Triplet
//Time complexity: O(N + max(a[i])^2)  
//Space complexity: O(max(a[i])^2)

package GFG;

public class PythagoreanTriplet_4 {

    public static void main(String[] args) {
        int arr[] = { 3, 2, 4, 6, 5 };
        System.out.println(pythagoreanTriplet(arr));
    }

    static boolean pythagoreanTriplet(int[] arr) {
        // code here
        int n = arr.length;
        int max = 0;
        // s1.
        // Find the maximum element
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
        }
        max = max * max;
        int[] freq = new int[max + 1];
        // Increase the freq of array elements
        for (int i = 0; i < n; i++) {
            freq[arr[i] * arr[i]]++;
        }
        // s2.
        // for all poss a
        for (int i = 1; i <= max; i++) { // since we want to itr in sorted form and in linear
            // If a is not there
            if (freq[i] == 0)
                continue;
            // for all possible b
            for (int j = 1; j <= max; j++) {
                // if there is no b
                // If a and b are the same and there is only one a
                if (freq[j] == 0 || (i == j && freq[i] == 1)) {
                    continue;
                }
                // now we have possibility of a and b, evaluate c, and check if it is present
                int c = (i + j);
                if (c > max) {
                    continue;
                }
                if (freq[c] > 0)
                    return true;
            }
        }
        return false;
    }
}
