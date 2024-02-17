//GFG
//Does array represent Heap
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class DoesArrayRepresentHeap {

    public static void main(String[] args) {
        long n = 6;
        long arr[] = { 90, 15, 10, 7, 12, 2 };
        System.out.println(countSub(arr, n));
    }

    public static boolean countSub(long arr[], long n) {
        // Your code goes here
        int j = 1;
        for (int i = 0; i < n; i++) {
            if (j < n && arr[j] > arr[i])
                return false;
            if (j + 1 < n && arr[j + 1] > arr[i])
                return false;
            j += 2;
        }
        return true;
    }
}
