//Leetcode
//1534. Count Good Triplets - Brute Force (Enumeration)
//Time complexity: O(N^3)
//Space complexity: O(1)

public class CountGoodTriplets {

    public static void main(String[] args) {
        int[] arr = { 3, 0, 1, 1, 9, 7 };
        int a = 7, b = 2, c = 3;
        System.out.println(countGoodTriplets(arr, a, b, c));
    }

    public static int countGoodTriplets(int[] arr, int a, int b, int c) {
        int good = 0;
        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a &&
                            Math.abs(arr[j] - arr[k]) <= b &&
                            Math.abs(arr[i] - arr[k]) <= c) {
                        good++;
                    }
                }
            }
        }
        return good;
    }
}
