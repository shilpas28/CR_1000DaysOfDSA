//GFG
//Quick Sort
//Time complexity: O(N*logN)
//Space complexity: O(logN)

public class QuickSort {

    public static void main(String[] args) {
        int N = 5;
        int arr[] = { 4, 1, 3, 9, 7 };
        quickSort(arr, N, N);
    }

    // Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high) {
        // code here
        if (low < high) {
            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);
            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(int arr[], int low, int high) {
        // your code here
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                // swap ar[i],arr[j]
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        int t = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = t;
        return i + 1;
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
