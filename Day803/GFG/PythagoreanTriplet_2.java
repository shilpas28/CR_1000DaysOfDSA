//GFG
//Pythagorean Triplet
//Time complexity: O(N^2)
//Space complexity: O(N)

package GFG;

import java.util.HashSet;

public class PythagoreanTriplet_2 {

    public static void main(String[] args) {
        int arr[] = { 3, 2, 4, 6, 5 };
        System.out.println(pythagoreanTriplet(arr));
    }

    static boolean pythagoreanTriplet(int[] arr) {
        // code here
        int n = arr.length;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++)
            set.add(arr[i] * arr[i]);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int c = arr[i] * arr[i] + arr[j] * arr[j];
                if (set.contains(c))
                    return true;
            }
        }
        return false;
    }
}
