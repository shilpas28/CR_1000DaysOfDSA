//GFG
//Number of pairs
//Time complexity: O((N + M)log(N))
//Space complexity: O(1) 

import java.util.Arrays;

public class NumberOfPairs {

    public static void main(String[] args) {
        int arr[] = { 2, 1, 6 }, brr[] = { 1, 5 };
        int M = arr.length;
        int N = brr.length;
        System.out.println(countPairs(arr, brr, M, N));
    }

    // Function to count number of pairs such that x^y is greater than y^x.
    public static long countPairs(int arr[], int brr[], int M, int N) {
        // code here
        long ans = 0, one = 0, two = 0, threeFour = 0;
        Arrays.sort(brr);
        for (int x : brr) {
            if (x == 1)
                one++;
            else if (x == 2)
                two++;
            else if (x == 3 || x == 4)
                threeFour++;
        }
        for (int x : arr) {
            if (x != 1) {
                ans += one;
                if (x == 2)
                    ans -= threeFour;
                if (x == 3)
                    ans += two;
                int index = binarySearch(x, brr);
                ans += (brr.length - index - 1);
            }
        }
        return ans;
    }

    static int binarySearch(int key, int brr[]) {
        int low = 0, high = brr.length - 1, mid, index = -1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (brr[mid] <= key) {
                index = mid;
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return index;
    }
}
