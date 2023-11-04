//GFG
//Find Transition Point
//Time complexity: O(logN)
//Space complexity: O(1)

package GFG;

public class FindTransitionPoint_2 {

    public static void main(String[] args) {
        int N = 5;
        int arr[] = { 0, 0, 0, 1, 1 };
        System.out.println(transitionPoint(arr, N));
    }

    static int transitionPoint(int arr[], int n) {
        // code here
        int l = 0, r = n - 1;
        int res = -1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == 1) {
                r = mid - 1;
                res = mid;
            } else
                l = mid + 1;
        }
        return res;
    }
}
