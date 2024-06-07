//GFG
//Maximum occured integer - Optimal
//Time complexity: O(n+maxx)
//Space complexity: O(maxx), maxx is maximum element in r[]

public class MaximumOccuredInteger_2 {

    public static void main(String[] args) {
        int n = 4, maxx = 15;
        int l[] = { 1, 4, 3, 1 }, r[] = { 15, 8, 5, 4 };
        System.out.println(maxOccured(n, l, r, maxx));
    }

    public static int maxOccured(int n, int l[], int r[], int maxx) {
        int arr[] = new int[maxx + 2];
        for (int i = 0; i < n; i++) {
            arr[l[i]]++;
            arr[r[i] + 1]--;
        }

        int max = arr[0], res = 0;
        for (int i = 1; i < maxx + 1; i++) {
            arr[i] += arr[i - 1];
            if (max < arr[i]) {
                max = arr[i];
                res = i;
            }
        }
        return res;
    }
}
