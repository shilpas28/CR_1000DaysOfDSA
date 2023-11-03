//GFG
//Pythagorean Triplet - Not accepted as TLE
//Time complexity: O(N^3)
//Space complexity: O(1)

package GFG;

public class PythagoreanTriplet {

    public static void main(String[] args) {
        int N = 5;
        int Arr[] = { 3, 2, 4, 6, 5 };
        System.out.println(checkTriplet(Arr, N));
    }

    static boolean checkTriplet(int[] arr, int n) {
        // code here
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {

                    int a = arr[i] * arr[i], b = arr[j] * arr[j], c = arr[k] * arr[k];
                    if (a == b + c || b == a + c || c == a + b)
                        return true;
                }
            }
        }
        return false;
    }
}
