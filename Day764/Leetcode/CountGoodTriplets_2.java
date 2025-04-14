//Leetcode
//1534. Count Good Triplets - Optimized Enumeration
//Time complexity: O((N^2) + (N*S))
//Space complexity: O(S) where S is the upper limit of the array values

public class CountGoodTriplets_2 {

    public static void main(String[] args) {
        int[] arr = { 3, 0, 1, 1, 9, 7 };
        int a = 7, b = 2, c = 3;
        System.out.println(countGoodTriplets(arr, a, b, c));
    }

    public static int countGoodTriplets(int[] arr, int a, int b, int c) {
        int good = 0;
        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            for (int k = i + 2; k < n; k++) {
                if (Math.abs(arr[k] - arr[i]) > c)
                    continue;
                for (int j = i + 1; j < k; j++) {
                    if (Math.abs(arr[i] - arr[j]) <= a &&
                            Math.abs(arr[j] - arr[k]) <= b) {
                        good++;
                    }
                }
            }
        }
        return good;
    }
}
