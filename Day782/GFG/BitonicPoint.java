//GFG
//Bitonic Point
//Time complexity: O(N)
//Space complexity: O(1) 

public class BitonicPoint {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 5, 7, 8, 3 };
        System.out.println(findMaximum(arr));
    }

    public static int findMaximum(int[] arr) {
        // code here
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1])
                return arr[i];
        }
        return arr[arr.length - 1];
    }
}
