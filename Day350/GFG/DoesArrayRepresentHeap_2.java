//GFG
//Does array represent Heap
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class DoesArrayRepresentHeap_2 {

    public static void main(String[] args) {
        long n = 6;
        long arr[] = { 90, 15, 10, 7, 12, 2 };
        System.out.println(countSub(arr, n));
    }

    public static boolean countSub(long arr[], long n) {
        // Your code goes here
        for (int i = 0; i < n; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (left < n && arr[i] < arr[left])
                return false;
            if (right < n && arr[i] < arr[right])
                return false;
        }
        return true;
    }
}
