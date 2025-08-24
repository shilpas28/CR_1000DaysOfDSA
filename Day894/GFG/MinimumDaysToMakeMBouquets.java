//GFG
//Minimum days to make M bouquets
//Time complexity: O(n * log(max(arr[i])))
//Space complexity: O(n)

public class MinimumDaysToMakeMBouquets {

    public static void main(String[] args) {
        int m = 3, k = 2;
        int arr[] = { 3, 4, 2, 7, 13, 8, 5 };
        System.out.println(minDaysBloom(arr, k, m));
    }

    public static int minDaysBloom(int[] arr, int k, int m) {
        // code here
        int l = arr[0], h = arr[0];
        if (m * k > arr.length) {
            return -1;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < l) {
                l = arr[i];
            }
            if (arr[i] > h) {
                h = arr[i];
            }
        }
        int re = -1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (find(arr, m, k, mid)) {
                re = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return re;
    }

    public static boolean find(int[] a, int boq, int flowers, int m) {
        int bc = 0, adj = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] <= m) {
                adj++;
                if (adj == flowers) {
                    bc++;
                    if (bc == boq) {
                        return true;
                    }
                    adj = 0;
                }
            } else {
                adj = 0;
            }
        }
        return false;
    }
}
