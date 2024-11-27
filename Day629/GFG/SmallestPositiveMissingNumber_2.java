//GFG
//Smallest Positive Missing Number - Ssame logic as previous but shorter code
//Time complexity: O(N)
//Space complexity: O(1)

public class SmallestPositiveMissingNumber_2 {

    public static void main(String[] args) {
        int arr[] = { 2, -3, 4, 1, 1, 7 };
        System.out.println(missingNumber(arr));
    }

    // Function to find the smallest positive number missing from the array.
    public static int missingNumber(int[] arr) {
        // Your code here
        int size = arr.length;
        for (int i = 0; i < size; ++i) {
            while (arr[i] >= 1 && arr[i] <= size && arr[i] != arr[arr[i] - 1]) {
                int t = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = t;
            }
        }
        for (int i = 0; i < size; ++i)
            if (arr[i] != i + 1)
                return i + 1;
        return size + 1;
    }
}
