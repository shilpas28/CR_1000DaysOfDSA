//GFG
//Heap Sort
//Time complexity: O(N*Log(N))
//Space complexity: O(1)

package GFG;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int N = 5;
        int arr[] = { 4, 1, 3, 9, 7 };
        heapSort(arr, N);
        System.out.println(Arrays.toString(arr));
    }

    // Function to build a Heap from array.
    static void buildHeap(int arr[], int n) {
        // Your code here
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
    }

    // Heapify function to maintain heap property.
    static void heapify(int arr[], int n, int i) {
        // Your code here
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < n && arr[left] > arr[largest])
            largest = left;
        if (right < n && arr[right] > arr[largest])
            largest = right;
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }

    // Function to sort an array using Heap Sort.
    public static void heapSort(int arr[], int n) {
        // code here
        buildHeap(arr, n);
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapify(arr, i, 0);
        }
    }
}
