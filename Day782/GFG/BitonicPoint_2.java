//GFG
//Bitonic Point
//Time complexity: O(logN)
//Space complexity: O(1)

public class BitonicPoint_2 {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 5, 7, 8, 3 };
        System.out.println(findMaximum(arr));
    }

    public static int findMaximum(int[] arr) {
        // code here
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((mid == 0 || arr[mid] > arr[mid - 1]) &&
                    (mid == arr.length - 1 || arr[mid] > arr[mid + 1])) {
                return arr[mid];
            }
            if (mid < arr.length - 1 && arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
