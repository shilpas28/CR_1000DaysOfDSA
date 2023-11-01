//GFG
//Frequencies of Limited Range Array Elements
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class FrequenciesOfLimitedRangeArrayElements_2 {

    public static void main(String[] args) {
        int N = 5;
        int arr[] = { 2, 3, 2, 3, 5 };
        int P = 5;
        frequencyCount(arr, N, P);
    }

    // Function to count the frequency of all elements from 1 to N in the array.
    public static void frequencyCount(int arr[], int N, int P) {
        // code here
        P++;
        for (int i = 0; i < N; i++) {
            int idx = arr[i] % P - 1;
            if (idx >= 0 && idx < N)
                arr[idx] += P; // increasing the frequency
        }
        for (int i = 0; i < N; i++) {
            arr[i] /= P;
        }
    }
}
