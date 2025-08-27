//GFG
//Count the number of possible triangles
//Time complexity: O(NlogN)
//Space complexity: O(1)

import java.util.Arrays;

public class CountTheNumberOfPossibleTriangles_2 {

    public static void main(String[] args) {
        int[] arr = { 4, 6, 3, 7 };
        System.out.println(countTriangles(arr));
    }

    public static int countTriangles(int arr[]) {
        // code here
        Arrays.sort(arr);
        int n = arr.length;
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            int l = 0, r = i - 1;
            while (l < r) {
                int sum = arr[l] + arr[r];
                if (sum > arr[i]) {
                    ans += (r - l);
                    r--;
                } else {
                    l++;
                }
            }
        }
        return ans;
    }
}
