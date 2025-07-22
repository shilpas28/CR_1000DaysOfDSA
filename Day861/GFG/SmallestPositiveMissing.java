//GFG
//Smallest Positive Missing
//Time complexity: O(N)
//Space complexity: O(1)

public class SmallestPositiveMissing {

    public static void main(String[] args) {
        int arr[] = { 2, -3, 4, 1, 1, 7 };
        System.out.println(missingNumber(arr));
    }

    public static int missingNumber(int[] arr) {
        // code here
        int i = 0;
        while (i < arr.length) {
            if (arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[arr[i] - 1]) {
                swap(arr, i, arr[i] - 1);
            } else
                i++;
        }
        for (i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1)
                return i + 1;
        }
        return arr.length + 1;
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
