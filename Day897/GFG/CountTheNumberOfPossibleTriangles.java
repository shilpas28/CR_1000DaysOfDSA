//GFG
//Count the number of possible triangles - Not expected as TLE 
//Time complexity: O(N^3)
//Space complexity: O(1)

import java.util.Arrays;

public class CountTheNumberOfPossibleTriangles {

    public static void main(String[] args) {
        int[] arr = { 4, 6, 3, 7 };
        System.out.println(countTriangles(arr));
    }

    public static int countTriangles(int arr[]) {
        // code here
        int n = arr.length;
        int res = 0;
        Arrays.sort(arr); // Optional, simplifies the condition

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] > arr[k]) {
                        res++;
                    }
                }
            }
        }

        return res;
    }
}
