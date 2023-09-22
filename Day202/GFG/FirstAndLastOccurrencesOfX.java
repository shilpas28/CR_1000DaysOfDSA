//GFG
//First and last occurrences of x
//Time complexity: O(logN)
//Space complexity: O(1)

package GFG;

import java.util.ArrayList;
import java.util.Arrays;

public class FirstAndLastOccurrencesOfX {

    public static void main(String[] args) {
        int n = 9, x = 5;
        int arr[] = { 1, 3, 5, 5, 5, 5, 67, 123, 125 };
        System.out.println(find(arr, n, x));
    }

    static ArrayList<Integer> find(int arr[], int n, int x) {
        // code here
        int li = bs1(arr, 0, n - 1, x);
        int ri = bs2(arr, 0, n - 1, x);
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(li, ri));
        return list;
    }

    static int bs1(int arr[], int l, int r, int x) {
        int res = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] < x)
                l = m + 1;
            else {
                if (arr[m] == x)
                    res = m;
                r = m - 1;
            }
        }
        return res;
    }

    static int bs2(int arr[], int l, int r, int x) {
        int res = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] > x)
                r = m - 1;
            else {
                if (arr[m] == x)
                    res = m;
                l = m + 1;
            }
        }
        return res;
    }
}
