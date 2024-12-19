//Leetcode
//769. Max Chunks To Make Sorted - Maximum Element
//Time complexity: O(N)
//Space complexity: O(1) 

public class MaxChunksToMakeSorted_4 {

    public static void main(String[] args) {
        int[] arr = { 4, 3, 2, 1, 0 };
        System.out.println(maxChunksToSorted(arr));
    }

    public static int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int chunks = 0, maxElement = 0;

        // Iterate over the array
        for (int i = 0; i < n; i++) {
            // Update maxElement
            maxElement = Math.max(maxElement, arr[i]);
            if (maxElement == i) {
                // All values in range [0, i] belong to the prefix arr[0:i]; a new chunk can be
                // formed
                chunks++;
            }
        }
        return chunks;
    }
}
